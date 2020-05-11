package com.coolyusen.exam.fallback.user;

import com.coolyusen.exam.client.user.RestStudentClient;
import com.coolyusen.exam.pojo.user.Student;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@Component
public class StudentClientFallback implements RestStudentClient {

    @Override
    public Student findStudentByUserId(Long userId) {
        return null;
    }

    @Override
    public long[] addStudent(Student student) {
        return new long[0];
    }

}
