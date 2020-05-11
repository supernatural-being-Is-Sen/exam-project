package com.coolyusen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coolyusen.exam.common.Dto;
import com.coolyusen.exam.common.DtoUtil;
import com.coolyusen.exam.pojo.exam.Exam;
import com.coolyusen.exam.pojo.exam.ExamResult;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.vo.StudentInfoVo;
import com.coolyusen.exam.vo.TeacherInfoVo;
import com.coolyusen.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExamController.class);


    /**
     * 发布考试
     * @param subjectMap 考试信息
     * @param session
     * @return
     */
    @RequestMapping(value = "publishingExamination", method = RequestMethod.POST)
    public Dto publishingExamination(@RequestParam Map<String,Object> subjectMap,
                                     HttpSession session) {
        //获取教师信息
        TeacherInfoVo teacherInfo =
                (TeacherInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        try{
            this.examService.publishingExamination(teacherInfo.getUserId(),Long.valueOf(subjectMap.get("examGrade").toString()),
                    Integer.parseInt(subjectMap.get("examTypeId").toString()), JSONObject.parseObject(subjectMap.get("exam").toString(),Exam.class),
                    JSONObject.parseObject(subjectMap.get("subjectIds").toString(),List.class));
            return DtoUtil.returnDataSuccess(Constants.CommonCode.SUCCESS);
        }catch (Exception e) {
            return DtoUtil.returnFail("error",Constants.CommonCode.EXCEPTION);
        }
    }

    /**
     * 保存考试基本信息
     * @param examBaseInfo
     * @param session
     * @return
     */
    @RequestMapping(value = "saveExamBaseInfo",method = RequestMethod.POST)
    public Dto saveExamBaseInfo(@RequestParam Map<String,String> examBaseInfo,
                                HttpSession session){
        //获取教师信息
        TeacherInfoVo teacherInfo =
                (TeacherInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        examBaseInfo.put("teacherId",teacherInfo.getTeacherId().toString());
        this.examService.saveExamBaseInfo(examBaseInfo);
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS);
    }

    /**
     * 获取考试基本信息
     * @param session
     * @return
     */
    @RequestMapping(value = "getExamBaseInfo",method = RequestMethod.GET)
    public Dto getExamBaseInfo(HttpSession session){
        //获取教师信息
        TeacherInfoVo teacherInfo =
                (TeacherInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,this.examService.getExamBaseInfo(teacherInfo));
    }

    /**
     * 考试基本信息
     *
     * @return
     */
    @RequestMapping(value = "examBaseInfo", method = RequestMethod.GET)
    public Dto examBaseInfo(@RequestParam(value = "pageNum", required = false) Integer pageNum,
                            @RequestParam(value = "pageSize", required = false) Integer pageSize,
                            HttpSession session) {
        //拿到用户信息
        StudentInfoVo studentInfo =
                (StudentInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        //判断页数
        if(pageNum == null) {
            pageNum = 1;
        }
        if(pageSize == null) {
            pageSize = Constants.Page.DEFAULT_PAGE;
        }
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,
                this.examService.findExamBaseInfo(studentInfo, pageNum, pageSize));
    }

    /**
     * 查找考试信息
     * @param examId
     * @return
     */
    @RequestMapping(value = "findExamInfo",method = RequestMethod.POST)
    public Dto findExamInfo(@RequestParam("examId") Long examId,
                            HttpSession session){
        //获取用户信息
        StudentInfoVo studentInfo =
                (StudentInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        Object[] examInfo = this.examService.findExamInfo(examId);
        examInfo[2] = studentInfo.getUserId();
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,examInfo);
    }

    /**
     * 提交考试
     * @param examResult
     * @return
     */
    @RequestMapping(value = "submitExam",method = RequestMethod.POST)
    public Dto submitExam(@RequestBody List<ExamResult> examResult,
                          HttpSession session){
        //获取用户信息
        StudentInfoVo studentInfo =
                (StudentInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,this.examService.studentSubmitExam(examResult));
    }

    /**
     * 考试基本信息
     * @param session
     * @return
     */
    @RequestMapping(value = "searchExamCondition",method = RequestMethod.GET)
    public Dto searchExamCondition(HttpSession session){
        //获取登录信息
        TeacherInfoVo teacherInfoVo = (TeacherInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        LOGGER.info("教师编号为："+ teacherInfoVo.getTeacherId());
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,
                this.examService.searchExamCondition(teacherInfoVo.getTeacherId()));
    }
}
