package com.coolyusen.exam.fallback.user;

import com.coolyusen.exam.client.user.RestStudentTypeClient;
import com.coolyusen.exam.pojo.user.StudentType;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@Component
public class StudentTypeClientFallback implements RestStudentTypeClient {

    @Override
    public StudentType findStudentTypeByStudentId(Integer studentId) {
        return null;
    }
}
