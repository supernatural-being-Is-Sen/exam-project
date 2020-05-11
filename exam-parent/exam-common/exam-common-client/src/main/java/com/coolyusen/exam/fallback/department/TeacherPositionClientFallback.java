package com.coolyusen.exam.fallback.department;

import com.coolyusen.exam.client.department.RestTeacherPositionClient;
import com.coolyusen.exam.pojo.department.TeacherPosition;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@Component
public class TeacherPositionClientFallback implements RestTeacherPositionClient {

    @Override
    public TeacherPosition findTeacherPositionById(Integer teacherPositionId) {
        return null;
    }
}
