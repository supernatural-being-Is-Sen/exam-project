package com.coolyusen.controller;

import com.alibaba.fastjson.JSONObject;
import com.coolyusen.exam.common.Dto;
import com.coolyusen.exam.common.DtoUtil;
import com.coolyusen.exam.common.RedisUtils;
import com.coolyusen.exam.pojo.test.UserTest;
import com.coolyusen.exam.pojo.test.UserTestAnswer;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import com.coolyusen.exam.vo.ExamInfoVo;
import com.coolyusen.exam.vo.StudentInfoVo;
import com.coolyusen.exam.vo.SubjectVo;
import com.coolyusen.exam.vo.UsersVo;
import com.coolyusen.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@RestController
@RequestMapping("test")
public class UserTestController {

    @Autowired
    private UserTestService userTestService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 读取近期考试信息
     * @return
     */
    @RequestMapping(value = "getSubjectInfo",method = RequestMethod.POST)
    public Dto getSubjectInfo(HttpSession session){
        StudentInfoVo userInfo =
                (StudentInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        //测试用户考试信息是否存在
        ExamInfoVo subjectBaseInfo = JSONObject.parseObject(String.valueOf(this.redisUtils.get(Constants.SubjectInfo.SUBJECT_BASE_INFO+userInfo.getStuId())),ExamInfoVo.class);
        List<SubjectVo> subjectInfo = JSONObject.parseObject(String.valueOf(this.redisUtils.get(Constants.SubjectInfo.SUBJECT_INFO+userInfo.getStuId())),List.class);
        if(EmptyUtils.isNotEmpty(subjectBaseInfo) && EmptyUtils.isNotEmpty(subjectInfo)){
            return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,
                    new Object[]{subjectInfo,subjectBaseInfo});
        }
        return DtoUtil.returnFail("题目不存在",Constants.CommonCode.EXCEPTION);
    }

    /**
     * 验证用户是否存在上次的测试中
     * @param session
     * @return
     */
    @RequestMapping(value = "testUserInfoIsExists",method = RequestMethod.POST)
    public Dto testUserInfoIsExists(HttpSession session){
        StudentInfoVo studentInfo =
                (StudentInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        //测试用户考试信息是否存在
        Object subjectBaseInfo = this.redisUtils.get(Constants.SubjectInfo.SUBJECT_BASE_INFO+studentInfo.getStuId());
        Object subjectInfo = this.redisUtils.get(Constants.SubjectInfo.SUBJECT_INFO+studentInfo.getStuId());
        if(EmptyUtils.isNotEmpty(subjectBaseInfo) && EmptyUtils.isNotEmpty(subjectInfo)){
            return DtoUtil.returnSuccess(Constants.CommonCode.OTHER);
        }else{
            return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS);
        }
    }

    /**
     * 根据测试类型编号和章节编号找到测试
     * @param testTypeId 测试类型编号
     * @param chapterId 章节编号
     * @param session
     * @return
     */
    @RequestMapping(value = "studentSelfTest",method = RequestMethod.POST)
    public Dto studentSelfTest(@RequestParam("testTypeId")Integer testTypeId,
                               @RequestParam("chapterId") Long chapterId,
                               HttpSession session){
        StudentInfoVo studentInfo = (StudentInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        if (EmptyUtils.isEmpty(studentInfo)) {
            return DtoUtil.returnFail("您好,请登录。",Constants.CommonCode.USER_NO_LOGIN);
        }
        //测试的题目信息
        Object[] examInfo =
                this.userTestService.studentSelfTest(chapterId, testTypeId,studentInfo.getStuId());
        //非空验证集合
        if (EmptyUtils.isEmpty(examInfo)){
            return DtoUtil.returnFail("没有找到题目", Constants.CommonCode.EXCEPTION);
        }
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,examInfo);
    }

    /**
     * 提交测试
     * @param userTestAnswers
     * @param session
     * @return
     */
    @RequestMapping(value = "studentSubjectTest",method = RequestMethod.POST)
    public Dto studentSubjectTest(@RequestBody List<UserTestAnswer> userTestAnswers,
                                  HttpSession session){
        //获取学生信息
        StudentInfoVo studentInfo = (StudentInfoVo)session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        if(EmptyUtils.isEmpty(studentInfo)){
            return DtoUtil.returnFail("您好,请登录",Constants.CommonCode.USER_NO_LOGIN);
        }
        UserTest userTest =
                this.userTestService.studentSubmitTest(userTestAnswers, studentInfo.getStuId());
        //判断返回值是否为空
        if(EmptyUtils.isEmpty(userTest)){
            return DtoUtil.returnFail("没有找到试题信息",Constants.CommonCode.EXCEPTION);
        }
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,userTest);
    }

    /**
     * 本次测试信息 *两个参数不可同时为空
     * @param testSubjectId 测试题目编号
     * @return
     */
    @RequestMapping(value = "studentTestInfo",method = RequestMethod.POST)
    public Dto testInfo(@RequestParam(value = "testSubjectId",required = false) Long testSubjectId,
                        @RequestParam(value = "userTestId",required = false) Long userTestId){
        Object[] subjectInfo =
                this.userTestService.studentTestInfo(testSubjectId, userTestId);
        if(EmptyUtils.isEmpty(subjectInfo)){
            return DtoUtil.returnFail("获取测试信息失败!",Constants.CommonCode.EXCEPTION);
        }
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,subjectInfo);
    }
}
