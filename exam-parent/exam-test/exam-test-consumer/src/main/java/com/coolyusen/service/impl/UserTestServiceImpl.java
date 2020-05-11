package com.coolyusen.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coolyusen.exam.client.subject.RestAnswerClient;
import com.coolyusen.exam.client.subject.RestKnowledgeClient;
import com.coolyusen.exam.client.subject.RestSubjectClient;
import com.coolyusen.exam.client.subject.RestSubjectTypeClient;
import com.coolyusen.exam.client.test.RestTestSubjectClient;
import com.coolyusen.exam.client.test.RestTestTypeClient;
import com.coolyusen.exam.client.test.RestUserTestAnswerClient;
import com.coolyusen.exam.client.test.RestUserTestClient;
import com.coolyusen.exam.common.RedisUtils;
import com.coolyusen.exam.pojo.subject.Answer;
import com.coolyusen.exam.pojo.subject.Subject;
import com.coolyusen.exam.pojo.subject.SubjectType;
import com.coolyusen.exam.pojo.test.TestSubject;
import com.coolyusen.exam.pojo.test.TestType;
import com.coolyusen.exam.pojo.test.UserTest;
import com.coolyusen.exam.pojo.test.UserTestAnswer;
import com.coolyusen.exam.utils.*;
import com.coolyusen.exam.vo.ExamInfoVo;
import com.coolyusen.exam.vo.SubjectVo;
import com.coolyusen.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@Service
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    private RestKnowledgeClient restKnowledgeClient;

    @Autowired
    private RestSubjectClient restSubjectClient;

    @Autowired
    private RestTestTypeClient restTestTypeClient;

    @Autowired
    private RestSubjectTypeClient restSubjectTypeClient;

    @Autowired
    private RestAnswerClient restAnswerClient;

    @Autowired
    private RestUserTestClient restUserTestClient;

    @Autowired
    private RestTestSubjectClient restTestSubjectClient;

    @Autowired
    private RestUserTestAnswerClient restUserTestAnswerClient;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private SubjectUtil subjectUtil;

    @Autowired
    private ListUtil listUtil;
    /**
     * 日期对象
     */
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Object[] studentSelfTest(Long chapterId, Integer testTypeId, Long stuId) {
        //查找到对应的知识点编号
        List<Long> knowledgeId =
                this.restKnowledgeClient.findKnowledgeIdByChapterId(chapterId);
        //依据知识点编号找到题目
        List<Subject> subjectList =
                this.restSubjectClient.findSubjectByKnowledgeId(knowledgeId);
        if(EmptyUtils.isEmpty(subjectList)){
            return null;
        }
        //依据测试类型编号查找测试
        TestType testType = this.restTestTypeClient.findTestTypeById(testTypeId);
        //打乱集合中的题目
        Collections.shuffle(subjectList);
        //判断考试类型
        //专项技能型
        if(testType.getId().equals(Constants.TestType.SPECIAL_SKILL_TYPE)){
            ExamInfoVo examInfoVo = new ExamInfoVo();
            List<SubjectVo> subjectVoList = this.specialSkillType(subjectList, testType, stuId);
            examInfoVo.setSubjectCount(subjectVoList.size());
            examInfoVo.setSubjectScore(Double.valueOf(testType.getTestScore()));
            //将题目基本信息存入到redis中
            this.redisUtils.set(Constants.SubjectInfo.SUBJECT_BASE_INFO+stuId,
                    JSON.toJSONString(examInfoVo));
            //将题目基本信息存入到redis中
            return new Object[]{subjectVoList,examInfoVo};
        }
        return null;
    }


    /**
     * 专项技能型测试练习
     * @return 完整题目
     */
    private List<SubjectVo> specialSkillType(List<Subject> subjectList, TestType testType, Long stuId){
        //找到题目的类型
        List<SubjectType> subjectType =
                this.restSubjectTypeClient.findSubjectType();
        //最终的题目
        List<Subject> subjects =
                ListUtil.interceptList(0, testType.getTestTypeCount(), subjectList);
        //题目id的list
        List<Long> subjectIdList = ListUtil.newArrayList();
        //最终返回结果
        List<SubjectVo> subjectVoList = ListUtil.newArrayList();
        //添加题目的信息
        this.subjectUtil.addSubjects(subjectVoList,subjects,subjectType,subjectIdList);
        //按照题目的id集合找到答案
        List<Answer> answerList =
                this.restAnswerClient.findAnswerBySubjectList(subjectIdList);
        //找到答案
        this.subjectUtil.addAnswerBySubjectIdList(answerList,subjectVoList);
        try{
            //添加用户测试,并返回用户测试编号
            long userTestId = this.addUserTest(stuId, testType);
            List<TestSubject> subjects1 = this.addTestSubjects(userTestId, subjectIdList);
            for (SubjectVo subjectVo : subjectVoList) {
                for (TestSubject testSubject : subjects1) {
                    if(subjectVo.getSubjectId() == (testSubject.getSubjectId())){
                        //测试id
                        subjectVo.setUserTestId(userTestId);
                        //测试题目id
                        subjectVo.setTestSubjectId(testSubject.getId());
                    }
                }
            }
        }catch (Exception e){
           e.printStackTrace();
           throw new RuntimeException("subject add fail");
        }
        //将题目存储到redis中去
            this.redisUtils.set(Constants.SubjectInfo.SUBJECT_INFO+stuId,
                    Constants.Redis_Expire.SESSION_TIMEOUT,JSON.toJSONString(subjectVoList));
        return subjectVoList;
    }

    /**
     * 添加用户测试
     * @param stuId 用户编号
     * @param testType 测试类型
     * @return 用户测试主键
     */
    private long addUserTest(long stuId,TestType testType){
        UserTest userTest = new UserTest();
        userTest.setStuId(stuId);
        userTest.setTestTypeId(testType.getId());
        return this.restUserTestClient.addUserTest(userTest);
    }

    /**
     * 添加测试题目
     * @param userTestId 用户测试编号
     * @param subjectIds 题目编号
     * @return 添加个数
     */
    private List<TestSubject> addTestSubjects(Long userTestId, List<Long> subjectIds){
        List<TestSubject> subjects = ListUtil.newArrayList();
        for (Long subjectId : subjectIds) {
            TestSubject testSubject = new TestSubject();
            testSubject.setUserTestId(userTestId);
            testSubject.setSubjectId(subjectId);
            subjects.add(testSubject);
        }
        return this.restTestSubjectClient.addTestSubjects(subjects);
    }

    /**
     * 根据用户自测保存所有的subjectVo信息
     * @param userTest
     * @return
     */
    private List<SubjectVo> saveSubjectVoByUserTest(UserTest userTest){
        List<SubjectVo> subjectVos = ListUtil.newArrayList();
        //根据测试类型编号找到题目的id
        List<TestSubject> testSubjects =
                this.restTestSubjectClient.findTestSubjectByUserTestId(userTest.getId());
        //题目id
        List<Long> subjectId = ListUtil.newArrayList();
        //循环便利添加题目信息
        for (TestSubject subject : testSubjects) {
            subjectId.add(subject.getSubjectId());
        }
        //查找所有题目类型
        List<SubjectType> subjectType =
                this.restSubjectTypeClient.findSubjectType();
        //根据题目的id找到题目
        List<Subject> subjects =
                this.restSubjectClient.findSubjectByIdList(subjectId);
        List<Long> subjectIdList = ListUtil.newArrayList();
        //添加题目的基本信息
        this.subjectUtil.addSubjects(subjectVos,subjects,subjectType,subjectIdList);
        List<Answer> answerList =
                this.restAnswerClient.findAnswerBySubjectList(subjectIdList);
        //添加题目答案
        this.subjectUtil.addAnswerBySubjectIdList(answerList,subjectVos);
        //添加其它设置
        for (SubjectVo subjectVo : subjectVos) {
            for (TestSubject subject : testSubjects) {
                if(subject.getSubjectId().equals(subjectVo.getSubjectId())){
                    subjectVo.setTestSubjectId(subject.getId());
                }
            }
            subjectVo.setUserTestId(userTest.getId());
        }
        return subjectVos;
    }


    @Override
    public UserTest studentSubmitTest(List<UserTestAnswer> userTestAnswerList, Long stuId) {
        //题目
        List<SubjectVo> subjectVos;
        //判断是否是本次考试
        if(this.redisUtils.exist(Constants.SubjectInfo.SUBJECT_INFO+stuId)){
            subjectVos = JSONObject.parseArray(
                            String.valueOf(this.redisUtils.get(Constants.SubjectInfo.SUBJECT_INFO+stuId))
                    , SubjectVo.class);
        }else{

            //不是通过本次测试进入的答案验证
            //随机查找一道测试题目
            TestSubject testSubject =
                    this.restTestSubjectClient.findTestSubjectById(userTestAnswerList.get(0).getTestSubjectId());
            //根据测试题目的id找到本次测试
            UserTest userTest =
                    this.restUserTestClient.findUserTestById(testSubject.getUserTestId());
            subjectVos = this.saveSubjectVoByUserTest(userTest);
        }

        //判断是否存在题目
        if (EmptyUtils.isEmpty(subjectVos)) {
            throw new RuntimeException("subject not found");
        }
        //获取本次测试的信息
        UserTest userTest =
                this.restUserTestClient.findUserTestById(subjectVos.get(0).getUserTestId());
        if(EmptyUtils.isEmpty(userTest)){
            throw new NullPointerException("user test not found");
        }
        //获取本次的测试类型
        TestType testType = this.
                restTestTypeClient.findTestTypeById(userTest.getTestTypeId());
        //总分数
        double score = 0;
        //判断单选题或多选题
        boolean subjectTypeJudge;
        //循环判断题目答案是否正确
        //用户答案
        List<Object> userAnswer;
        for (SubjectVo subjectVo : subjectVos) {
            subjectTypeJudge = false;
            userAnswer = ListUtil.newArrayList();
            for (UserTestAnswer userTestAnswer : userTestAnswerList) {
                //判断是否为同一道题
                if(subjectVo.getTestSubjectId().equals(userTestAnswer.getTestSubjectId())){
                    //判断是否为多选题
                    if(!subjectVo.getSubjectTypeId().equals(Constants.SubjectType.MULTPLE_CHOICE_QUESTION)){
                        //判断答案是否正确
                        for (Answer answer : subjectVo.getAnswerList()) {
                            if(answer.getId().equals(userTestAnswer.getAnswer())){
                                if(answer.getBoolAnswer()){
                                    score += testType.getTestScore();
                                }
                            }
                        }
                    }else{
                        subjectTypeJudge = true;
                        userAnswer.add(userTestAnswer.getAnswer());
                    }
                }
            }
            //判断是否为多选题
            if(subjectTypeJudge){
                //用户正确数量
                int count = 0;
                //获取答案集合
                List<Answer> answerList =
                        subjectVo.getAnswerList();
                List<Answer> correctAnswer =
                        AnswerUtil.filterErrorAnswer(answerList);
                //过滤正确答案
                //判断用户选择数量是否正确
                if(correctAnswer.size() == userAnswer.size()){
                    //判断用户多选题答案数量是否正确
                    for (Answer answer : correctAnswer) {
                        for (Object o : userAnswer) {
                            if(o.equals(answer.getId())){
                                count ++;
                            }
                        }
                    }
                    //进行分数添加
                    if(count == correctAnswer.size()){
                        score += testType.getTestScore();
                    }
                }
            }
        }
        //批量添加用户答案
        this.restUserTestAnswerClient.addUserTestAnswer(userTestAnswerList);
        userTest.setEndTime(this.dateFormat.format(new Date()));
        userTest.setScore(score);
        userTest.setComplete(true);
        this.restUserTestClient.updateUserTestInfo(userTest);
        //清除用户上次考试的缓存
        this.redisUtils.delete(Constants.SubjectInfo.SUBJECT_BASE_INFO+stuId);
        return userTest;
    }

    @Override
    public Object[] studentTestInfo(Long testSubjectId,Long userTestId) {
        //本次测试
        UserTest userTest;
        if(userTestId == null){
            //找到测试对象
            TestSubject testSubject =
                    this.restTestSubjectClient.findTestSubjectById(testSubjectId);
            userTest = this.restUserTestClient.findUserTestById(testSubject.getUserTestId());
        }else{
            userTest = this.restUserTestClient.findUserTestById(userTestId);
        }
        //找到本次测试的所有测试题目
        List<TestSubject> testSubjectList =
                this.restTestSubjectClient.findTestSubjectByUserTestId(userTest.getId());
        List<Long> testSubjectIdList = ListUtil.newArrayList();
        for (TestSubject subject : testSubjectList) {
            testSubjectIdList.add(subject.getId());
        }
        //找到所有学生答案
        List<UserTestAnswer> userTestAnswerList =
                this.restUserTestAnswerClient.findUserTestAnswerByTestSubjecIdtList(testSubjectIdList);
        //所有题目类型
        List<SubjectType> subjectTypes =
                this.restSubjectTypeClient.findSubjectType();
        //题目编号
        List<Long> subjectIdList = ListUtil.newArrayList();
        for (TestSubject testSubject : testSubjectList) {
            subjectIdList.add(testSubject.getSubjectId());
        }
        //本次测试的所有题目
        List<Subject> subjects =
                this.restSubjectClient.findSubjectByIdList(subjectIdList);
        //最终返回结果
        List<SubjectVo> subjectVoList = ListUtil.newArrayList();
        //找到所有的题目
        this.subjectUtil.addSubjects(subjectVoList,subjects,subjectTypes,subjectIdList);
        //根据题目id集合找到答案
        List<Answer> answers =
                this.restAnswerClient.findAnswerBySubjectList(subjectIdList);
        //添加答案
        this.subjectUtil.addAnswerBySubjectIdList(answers,subjectVoList);
        //赋值testSubject
        for (SubjectVo subjectVo : subjectVoList) {
            for (TestSubject testSubject : testSubjectList) {
                if(subjectVo.getSubjectId().equals(testSubject.getSubjectId())){
                    subjectVo.setTestSubjectId(testSubject.getId());
                }
            }
        }
        //便利题目将用户答案加入进来
        List<Object> studentAnswer;
        for (SubjectVo subjectVo : subjectVoList) {
            studentAnswer = ListUtil.newArrayList();
            boolean stuFlag;
            int correctCount;
            for (UserTestAnswer userTestAnswer : userTestAnswerList) {
                if(subjectVo.getTestSubjectId().equals(userTestAnswer.getTestSubjectId())){
                    studentAnswer.add(userTestAnswer.getAnswer());
                }
            }
            stuFlag = false;
            correctCount = 0;
            //测试答案是否正确
            List<Answer> answerList = subjectVo.getAnswerList();
            //正确答案
            List<Answer> correctList = AnswerUtil.filterErrorAnswer(answerList);
            if(studentAnswer.size() == correctList.size()){
                for (Answer answer : correctList) {
                    for (Object o : studentAnswer) {
                        //判断答案是否正确
                        if(answer.getId().toString().equals(o) || answer.getAnswer().equals(o)){
                            correctCount++;
                        }
                    }
                }
                if(correctCount == correctList.size()){
                    stuFlag = true;
                }
            }
            subjectVo.setCorrect(stuFlag);
            subjectVo.setStuAnswer(studentAnswer.toArray());
        }
        //找到测试类型
        TestType testType =
                this.restTestTypeClient.findTestTypeById(userTest.getTestTypeId());
        //测试信息
        ExamInfoVo examInfoVo = new ExamInfoVo();
        examInfoVo.setSubjectCount(subjectVoList.size());
        examInfoVo.setSubjectScore(Double.valueOf(testType.getTestScore()));
        examInfoVo.setScore(userTest.getScore());
        return new Object[]{subjectVoList,examInfoVo};
    }
}
