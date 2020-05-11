package com.coolyusen.exam.fallback.grade;

import com.coolyusen.exam.client.grade.RestGradeClient;
import com.coolyusen.exam.pojo.grade.Grade;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@Component
public class GradeClientFallback implements RestGradeClient {

    @Override
    public Grade findGradeById(Long gradeId) {
        return null;
    }

    @Override
    public List<Grade> findGradeAll() {
        return null;
    }

    @Override
    public List<Grade> findGradeByIds(List<Long> gradeIds) {
        return null;
    }
}
