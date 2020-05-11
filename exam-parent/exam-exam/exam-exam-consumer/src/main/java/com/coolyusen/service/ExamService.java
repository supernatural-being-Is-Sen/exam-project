package com.coolyusen.service;

import com.coolyusen.exam.pojo.exam.Exam;
import com.coolyusen.exam.pojo.exam.ExamResult;
import com.coolyusen.exam.utils.page.PageUtil;
import com.coolyusen.exam.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
public interface ExamService {

    /**
     * 发布考试
     * @param userId 教师编号
     * @param gradeId 年级编号
     * @param examTypeId 考试类型编号
     * @param subjectIds
     * @return
     */
    void publishingExamination(Long userId, Long gradeId, Integer examTypeId, Exam exam,List<Integer> subjectIds);

    /**
     * 获取考试的基本信息
     * @param studentInfoVo
     * @param pageNum 页码
     * @param pageSize 长度
     * @return
     */
    PageUtil<ExamBaseInfoVo> findExamBaseInfo(StudentInfoVo studentInfoVo,int pageNum,int pageSize);

    /**
     * 找到考试题目信息
     * @param examId
     * @return
     */
    Object[] findExamInfo(Long examId);

    /**
     * 学生提交考试
     * @param examResults
     * @return
     */
    double studentSubmitExam(List<ExamResult> examResults);

    /**
     * 搜索考试条件
     * @param teacherId 教师编号
     * @return
     */
    Map<String,Object> searchExamCondition(Long teacherId);

    /**
     * 保存考试基本信息
     * @param examBaseInfo
     */
    void saveExamBaseInfo(Map<String,String> examBaseInfo);

    /**
     * 获取考试基本信息
     * @param teacherInfoVo
     * @return
     */
    Object[] getExamBaseInfo(TeacherInfoVo teacherInfoVo);
}
