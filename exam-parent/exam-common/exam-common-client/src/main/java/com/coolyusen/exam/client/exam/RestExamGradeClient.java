package com.coolyusen.exam.client.exam;

import com.coolyusen.exam.fallback.exam.ExamGradeClientFallback;
import com.coolyusen.exam.pojo.exam.ExamGrade;
import com.coolyusen.exam.vo.ExamBaseInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/9
 */
@FeignClient(value = "exam-exam-provider",fallback = ExamGradeClientFallback.class)
public interface RestExamGradeClient {

    /**
     * 添加一条考试班级信息
     * @param examGrade 考试班级对象
     */
    @RequestMapping(value = "addExamGrade",method = RequestMethod.POST)
    void addExamGrade(@RequestBody ExamGrade examGrade);

    /**
     * 根据班级编号找到考试信息
     * @return
     */
    @RequestMapping(value = "findExamGradeByGradeId",method = RequestMethod.POST)
    List<ExamGrade> findExamGradeByGradeId(@RequestParam("gradeId") Long gradeId);

    /**
     * 根据年级编号找到考试基本信息
     * @param gradeId
     * @return
     */
    @RequestMapping(value = "findExamBaseInfoByGradeId",method = RequestMethod.POST)
    List<ExamBaseInfoVo> findExamBaseInfoByGradeId(@RequestParam("gradeId") Long gradeId);
}
