package com.coolyusen.exam.client.grade;

import com.coolyusen.exam.fallback.grade.TeacherOrderGradeClientFallback;
import com.coolyusen.exam.pojo.grade.TeacherOrderGrade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@FeignClient(value = "exam-grade-provider",fallback = TeacherOrderGradeClientFallback.class)
public interface RestTeacherOrderGradeClient {

    /**
     * 根据教师编号查找教师所在班级
     * @param teacherId 教师编号
     * @return
     */
    @RequestMapping(value = "findTeacherOrderGradeByTeacherId",method = RequestMethod.POST)
    List<TeacherOrderGrade> findTeacherOrderGradeByTeacherId(@RequestParam("teacherId") Long teacherId);
}
