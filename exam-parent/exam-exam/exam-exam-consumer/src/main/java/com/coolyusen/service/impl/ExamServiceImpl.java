package com.coolyusen.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coolyusen.exam.client.curriculum.RestChapterClient;
import com.coolyusen.exam.client.curriculum.RestCurriculumClient;
import com.coolyusen.exam.client.curriculum.RestCurriculumStageClient;
import com.coolyusen.exam.client.exam.*;
import com.coolyusen.exam.client.grade.RestGradeClient;
import com.coolyusen.exam.client.grade.RestTeacherOrderGradeClient;
import com.coolyusen.exam.client.subject.RestAnswerClient;
import com.coolyusen.exam.client.subject.RestKnowledgeClient;
import com.coolyusen.exam.client.subject.RestSubjectClient;
import com.coolyusen.exam.client.subject.RestSubjectTypeClient;
import com.coolyusen.exam.client.user.RestUsersClient;
import com.coolyusen.exam.common.RedisUtils;
import com.coolyusen.exam.pojo.curriculum.Curriculum;
import com.coolyusen.exam.pojo.exam.*;
import com.coolyusen.exam.pojo.grade.Grade;
import com.coolyusen.exam.pojo.grade.TeacherOrderGrade;
import com.coolyusen.exam.pojo.subject.Answer;
import com.coolyusen.exam.pojo.subject.Subject;
import com.coolyusen.exam.pojo.subject.SubjectType;
import com.coolyusen.exam.pojo.user.Users;
import com.coolyusen.exam.utils.*;
import com.coolyusen.exam.utils.page.Page;
import com.coolyusen.exam.utils.page.PageUtil;
import com.coolyusen.exam.vo.*;
import com.coolyusen.service.ExamService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private RestExamClient restExamClient;

    @Autowired
    private RestExamGradeClient restExamGradeClient;

    @Autowired
    private RestExamInformationClient restExamInformationClient;

    @Autowired
    private RestExamTypeClient restExamTypeClient;

    @Autowired
    private RestCurriculumClient restCurriculumClient;

    @Autowired
    private RestGradeClient restGradeClient;

    @Autowired
    private RestUsersClient restUsersClient;

    @Autowired
    private RestChapterClient restChapterClient;

    @Autowired
    private RestKnowledgeClient restKnowledgeClient;

    @Autowired
    private RestSubjectClient restSubjectClient;

    @Autowired
    private RestSubjectTypeClient restSubjectTypeClient;

    @Autowired
    private RestAnswerClient restAnswerClient;

    @Autowired
    private RestExamScoreClient restExamScoreClient;

    @Autowired
    private RestCurriculumStageClient restCurriculumStageClient;

    @Autowired
    private RestExamResultClient restExamResultClient;

    @Autowired
    private RestTeacherOrderGradeClient restTeacherOrderGradeClient;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private SubjectUtil subjectUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void publishingExamination(
            Long userId, Long gradeId, Integer examTypeId, Exam exam,List<Integer> subjectIds) {
        //根据考试类型编号查找到考试类型
        ExamType examType =
                this.restExamTypeClient.findExamTypeById(examTypeId);
        exam.setUserId(userId);
        //判断考试类型
        //模拟考试型
        if(examType.getId().equals(Constants.ExamType.MOCKEXAM)){
            //添加考试
            exam.setExamTypeId(examTypeId);
            long examId = this.restExamClient.addExam(exam);
            //添加考试班级
            ExamGrade examGrade = new ExamGrade();
            examGrade.setExamId(examId);
            examGrade.setGradeId(gradeId);
            this.restExamGradeClient.addExamGrade(examGrade);
            //批量添加考试信息
            List<ExamInformation> examInformations = ListUtil.newArrayList();
            for (Integer subjectId : subjectIds) {
                ExamInformation examInformation = new ExamInformation();
                examInformation.setExamId(examId);
                examInformation.setSubjectId((long)subjectId);
                examInformations.add(examInformation);
            }
            //批量添加考试信息
            List<ExamInformation> examInformationIdList =
                    this.restExamInformationClient.addExamInformationByList(examInformations);
        }
    }

    @Override
    public PageUtil<ExamBaseInfoVo> findExamBaseInfo(StudentInfoVo studentInfoVo
            ,int pageNum,int pageSize) {
        //找到符合条件的考试班级
        List<ExamBaseInfoVo> examBaseInfo =
                this.restExamGradeClient.findExamBaseInfoByGradeId(studentInfoVo.getGradeId());
        //判断是否出现完成考试
        List<ExamBaseInfoVo> examBaseInfos =
                this.filterExamBaseInfo(studentInfoVo.getUserId(),examBaseInfo);
        if(EmptyUtils.isEmpty(examBaseInfos)) {
            return null;
        }
        List<Long> teacherIds = ListUtil.newArrayList();
        for (ExamBaseInfoVo baseInfo : examBaseInfos) {
            teacherIds.add(baseInfo.getUserId());
            baseInfo.setGradeName(studentInfoVo.getGradeName());
        }
        List<Users> users =
                this.restUsersClient.findUsersByIds(teacherIds);
        //找到相同的教师编号
        for (ExamBaseInfoVo baseInfo : examBaseInfos) {
            for (Users user : users) {
                if(baseInfo.getUserId().equals(user.getId())) {
                    baseInfo.setTeacherName(user.getUsername());
                }
            }
        }
        Page<ExamBaseInfoVo> page = new Page<>(pageNum,pageSize);
        PageUtil<ExamBaseInfoVo> pageUtil = new PageUtil<>(page);
        pageUtil.setIPage(examBaseInfos);
        return pageUtil;
    }

    @Override
    public Object[] findExamInfo(Long examId) {
        //找到考试
        Exam exam = this.restExamClient.findExamById(examId);
        //找到考试类型
        ExamType examType =
                this.restExamTypeClient.findExamTypeById(exam.getExamTypeId());
        List<ExamInformation> examInformationList =
                this.restExamInformationClient.findExamInformationByExamId(examId);
        List<Long> subjectIds = ListUtil.newArrayList();
        for (ExamInformation examInformation : examInformationList) {
            subjectIds.add(examInformation.getSubjectId());
        }
        //根据编号集合找到所有的题目
        List<Subject> subjects =
                this.restSubjectClient.findSubjectByIdList(subjectIds);
        //最终返回结果
        List<SubjectVo> subjectVos = ListUtil.newArrayList();
        //拿到题目信息
        //查找到题目类型
        List<SubjectType> subjectTypes = this.restSubjectTypeClient.findSubjectType();
        this.subjectUtil.addSubjects(subjectVos,subjects,subjectTypes,subjectIds);
        //根据题目找到答案
        List<Answer> answerList =
                this.restAnswerClient.findAnswerBySubjectList(subjectIds);
        //进行题目答案添加
        this.subjectUtil.addAnswerBySubjectIdList(answerList,subjectVos);
        //赋予其它值
        for (SubjectVo subjectVo : subjectVos) {
            for (ExamInformation examInformation : examInformationList) {
                if(subjectVo.getSubjectId().equals(examInformation.getSubjectId())) {
                    subjectVo.setExamId(examId);
                    subjectVo.setExamInformationId(examInformation.getId());
                }
            }
        }
        return new Object[]{subjectVos,new ExamInfoVo(examType.getSubjectCount(),
                examType.getExamTime() * 60,
                examType.getSubjectScore(),examType.getSubjectScore() * examType.getSubjectScore()),null};
    }

    @Override
    public double studentSubmitExam(List<ExamResult> examResults) {
        //根据考试信息编号找到考试信息
        ExamInformation examInformation =
                this.restExamInformationClient.findExamInformationById(examResults.get(0).getExamInformationId());
        //根据考试编号找到考试信息
        Exam exam = this.restExamClient.findExamById(examInformation.getExamId());
        if(EmptyUtils.isEmpty(exam)) {
            throw new NullPointerException("考试信息为空");
        }
        //根据考试编号找到所有的考试信息
        List<ExamInformation> examInformations =
                this.restExamInformationClient.findExamInformationByExamId(exam.getId());
        //找到考试题目信息
        List<SubjectVo> subjectVos = this.saveSubjectVoByExam(exam,examInformations);
        //考试类型
        ExamType examType =
                this.restExamTypeClient.findExamTypeById(exam.getExamTypeId());
        //总分数
        double score = 0;
        //判断单选题或多选题
        boolean subjectTypeJudge;
        //循环判断题目答案是否正确
        //用户答案
        List<Object> userAnswer = null;
        for (SubjectVo subjectVo : subjectVos) {
            subjectTypeJudge = false;
            userAnswer = ListUtil.newArrayList();
            for (ExamInformation examInformation1 : examInformations) {
                for (ExamResult examResult : examResults) {
                    //判断是否为同一道题
                    if(subjectVo.getExamInformationId().equals(examInformation1.getId()) &&
                            examInformation1.getId().equals(examResult.getExamInformationId())){
                        //判断是否为多选题
                        if(!subjectVo.getSubjectTypeId().equals(Constants.SubjectType.MULTPLE_CHOICE_QUESTION)){
                            //判断答案是否正确
                            for (Answer answer : subjectVo.getAnswerList()) {
                                if(answer.getId().equals(examResult.getUserAnswer())){
                                    if(answer.getBoolAnswer()){
                                        score += examType.getSubjectScore();
                                    }
                                }
                            }
                        }else{
                            subjectTypeJudge = true;
                            userAnswer.add(examResult.getUserAnswer());
                        }
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
                        score += examType.getSubjectScore();
                    }
                }
            }
        }
        //添加学生考试答案
        this.restExamResultClient.addExamResultList(examResults);
        //添加学生考试分数
        ExamScore examScore = new ExamScore();
        examScore.setExamId(exam.getId());
        examScore.setUserId(examResults.get(0).getUserId());
        examScore.setScore(score);
        this.restExamScoreClient.addExamScore(examScore);
        return score;
    }

    @Override
    public Map<String, Object> searchExamCondition(Long teacherId) {
        //查询教师所授课的班级
        List<TeacherOrderGrade> teacherOrderGrades =
                this.restTeacherOrderGradeClient.findTeacherOrderGradeByTeacherId(teacherId);
        List<Long> gradeIds = ListUtil.newArrayList();
        teacherOrderGrades.forEach(
                teacherOrderGrade -> {
                    gradeIds.add(teacherOrderGrade.getGradeId());
                }
        );
        //搜索对应的班级
        List<Grade> grades = this.restGradeClient.findGradeByIds(gradeIds);
        //搜索考试类型
        List<ExamType> examType = this.restExamTypeClient.findExamType();
        return ImmutableMap.of("grades",grades,"examType",examType);
    }

    @Override
    public void saveExamBaseInfo(Map<String, String> examBaseInfo) {
        this.redisUtils.set(Constants.ExamInfo.EXAM_BASE_INFO+examBaseInfo.get("teacherId"),
                Constants.Redis_Expire.DEFAULT_EXPIRE,JSON.toJSONString(examBaseInfo));
    }

    @Override
    public Object[] getExamBaseInfo(TeacherInfoVo teacherInfoVo) {
        //获取考试基本信息
        Map<String,String> examBaseInfo = JSONObject.parseObject(redisUtils.get(Constants.ExamInfo.EXAM_BASE_INFO + teacherInfoVo.getTeacherId()).toString()
                , Map.class);
        //获取考试类型信息
        String examTypeId = examBaseInfo.get("examType");
        ExamType examType = this.restExamTypeClient.findExamTypeById(Integer.parseInt(examTypeId));
        //找到班级信息
        String examGrade = examBaseInfo.get("examGrade");
        Grade grade = this.restGradeClient.findGradeById(Long.parseLong(examGrade));
        //根据阶段查找对应的课程
        List<Integer> curriculumIds = this.restCurriculumStageClient.findCurriculumIdByStageId(grade.getStageId());
        //找到对应的课程
        List<Curriculum> curriculumByIdList = this.restCurriculumClient.findCurriculumByIdList(curriculumIds);
        Exam exam = new Exam(examBaseInfo.get("examName"),examBaseInfo.get("examDetail"),
                examBaseInfo.get("endTime"));
        return new Object[]{teacherInfoVo.getNickName(),examType,grade,curriculumByIdList,JSON.toJSONString(exam)};
    }

    /**
     * 过滤考试基本信息
     * @param examBaseInfos
     * @return
     */
    private List<ExamBaseInfoVo> filterExamBaseInfo(Long userId, List<ExamBaseInfoVo> examBaseInfos){
        List<ExamScore> examScores =
                this.restExamScoreClient.findExamScoreByUserId(userId);
        if(!examScores.isEmpty()) {
            for (int i = 0; i <examBaseInfos.size();i++) {
                for (ExamScore examScore : examScores) {
                    if(examBaseInfos.get(i).getExamId().equals(examScore.getExamId())) {
                        examBaseInfos.remove(i);
                    }
                }
            }
        }
        return examBaseInfos;
    }

    /**
     * 模拟考试型号
     * @param subjectIds
     * @param subjects 题目
     * @return
     */
    public List<SubjectVo> mockExam(List<Long> subjectIds,List<Subject> subjects){
        //找到所有的题目类型
        List<SubjectType> subjectTypes =
                this.restSubjectTypeClient.findSubjectType();
        //最终返回结果
        List<SubjectVo> subjectVos = ListUtil.newArrayList();
        //添加题目信息
        this.subjectUtil.addSubjects(subjectVos,subjects,subjectTypes,subjectIds);
        //获取题目的答案list
        List<Answer> answers =
                this.restAnswerClient.findAnswerBySubjectList(subjectIds);
        this.subjectUtil.addAnswerBySubjectIdList(answers,subjectVos);
        return subjectVos;
    }

    /**
     * 根据考试保存所有的subjectVo信息
     * @param exam 考试
     * @return
     */
    private List<SubjectVo> saveSubjectVoByExam(Exam exam,List<ExamInformation> examInformations){
        List<SubjectVo> subjectVos = ListUtil.newArrayList();
        //题目id
        List<Long> subjectId = ListUtil.newArrayList();
        //循环便利添加题目信息
        for (ExamInformation subject : examInformations) {
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
            for (ExamInformation subject : examInformations) {
                if(subject.getSubjectId().equals(subjectVo.getSubjectId())){
                    subjectVo.setExamInformationId(subject.getId());
                }
            }
            subjectVo.setExamId(exam.getId());
        }
        return subjectVos;
    }

    /**
     * 根据班级编号查找题目
     * @param gradeId
     * @return
     */
    private List<Subject> findSubjectListByGradeId(Long gradeId,Long chapterId){
        //根据班级编号查找班级
        Grade grade =
                this.restGradeClient.findGradeById(gradeId);
        //判断章节是否为空，如果为空则默认为根据课程查找所有章节
        if(EmptyUtils.isEmpty(chapterId)){
            //根据学生班级查找学生所在阶段所持有的课程
            List<Integer> curriculumStages =
                    this.restCurriculumStageClient.findCurriculumIdByStageId(grade.getStageId());
            //判断这个阶段是否存在课程
            if(EmptyUtils.isEmpty(curriculumStages)){
                throw new NullPointerException("No course at stage");
            }
            //根据课程List查找对应的课程
            List<Curriculum> curriculumList =
                    this.restCurriculumClient.findCurriculumByIdList(curriculumStages);
            //找到对应的章节
            List<Integer> curriculumIdList = ListUtil.newArrayList();
            for (Curriculum curriculum : curriculumList) {
                curriculumIdList.add(curriculum.getId());
            }
            List<Long> chapterIdList =
                    this.restChapterClient.findChapterIdListByCurriculumList(curriculumIdList);
            //根据章节list找到知识点
            List<Long> knowledgeIdList =
                    this.restKnowledgeClient.findKnowledgeIdByChapterList(chapterIdList);
            return this.restSubjectClient.findSubjectByKnowledgeId(knowledgeIdList);
        }else{
            //根据章节查找所有的知识点
            List<Long> knowledgeIdList =
                    this.restKnowledgeClient.findKnowledgeIdByChapterId(chapterId);
            if(EmptyUtils.isEmpty(knowledgeIdList)){
                throw new NullPointerException("knowledge not found");
            }
            //根据知识点查找题目
            List<Subject> subjects =
                    this.restSubjectClient.findSubjectByKnowledgeId(knowledgeIdList);
            return subjects;
        }
    }

}
