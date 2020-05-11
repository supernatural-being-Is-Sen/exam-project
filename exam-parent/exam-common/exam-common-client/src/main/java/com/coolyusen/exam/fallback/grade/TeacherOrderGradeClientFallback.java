package com.coolyusen.exam.fallback.grade;

import com.coolyusen.exam.client.grade.RestTeacherOrderGradeClient;
import com.coolyusen.exam.pojo.grade.TeacherOrderGrade;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@Component
public class TeacherOrderGradeClientFallback implements RestTeacherOrderGradeClient {

    @Override
    public List<TeacherOrderGrade> findTeacherOrderGradeByTeacherId(Long teacherId) {
        return null;
    }
}
