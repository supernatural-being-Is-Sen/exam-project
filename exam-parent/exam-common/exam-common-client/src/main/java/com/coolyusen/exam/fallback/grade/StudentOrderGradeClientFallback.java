package com.coolyusen.exam.fallback.grade;

import com.coolyusen.exam.client.grade.RestStudentOrderGradeClient;
import com.coolyusen.exam.pojo.grade.StudentOrderGrade;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@Component
public class StudentOrderGradeClientFallback implements RestStudentOrderGradeClient {

    @Override
    public StudentOrderGrade findStudentOrderGradeByStudentId(Long studentId) {
        return null;
    }

    @Override
    public Integer addStudentOrderGrade(StudentOrderGrade studentOrderGrade) {
        return null;
    }
}
