package com.coolyusen.exam.client.grade;

import com.coolyusen.exam.fallback.grade.StudentOrderGradeClientFallback;
import com.coolyusen.exam.pojo.grade.StudentOrderGrade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@FeignClient(value = "exam-grade-provider",fallback = StudentOrderGradeClientFallback.class)
public interface RestStudentOrderGradeClient {

    /**
     * 依照学生编号查找学生所在班级
     * @param studentId
     * @return
     */
    @RequestMapping(value = "findStudentOrderGradeByStudentId",method = RequestMethod.POST)
    StudentOrderGrade findStudentOrderGradeByStudentId(@RequestParam("studentId") Long studentId);

    /**
     * 添加一个学生班级记录
     * @param studentOrderGrade
     * @return
     */
    @RequestMapping(value = "addStudentOrderGrade",method = RequestMethod.POST)
    Integer addStudentOrderGrade(@RequestBody StudentOrderGrade studentOrderGrade);
}