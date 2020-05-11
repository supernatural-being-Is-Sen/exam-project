package com.coolyusen.exam.fallback.exam;

import com.coolyusen.exam.client.exam.RestExamScoreClient;
import com.coolyusen.exam.pojo.exam.ExamScore;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/1/22
 */
@Component
public class ExamScoreClientFallback implements RestExamScoreClient {

    @Override
    public List<ExamScore> findExamScoreByUserId(Long userId) {
        return null;
    }

    @Override
    public void addExamScore(ExamScore examScore) {

    }
}
