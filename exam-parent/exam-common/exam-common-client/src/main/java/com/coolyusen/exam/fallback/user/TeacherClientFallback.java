package com.coolyusen.exam.fallback.user;

import com.coolyusen.exam.client.user.RestTeacherClient;
import com.coolyusen.exam.pojo.user.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@Component
public class TeacherClientFallback implements RestTeacherClient {


    @Override
    public Teacher findTeacherByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Teacher> findTeacherByTeacherIds(List<Long> teacherIds) {
        return null;
    }
}
