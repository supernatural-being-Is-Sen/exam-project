package com.coolyusen.exam.fallback.exam;

import com.coolyusen.exam.client.exam.RestExamClient;
import com.coolyusen.exam.pojo.exam.Exam;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@Component
public class ExamClientFallback implements RestExamClient {

    @Override
    public Long addExam(Exam exam) {
        return null;
    }

    @Override
    public Exam findExamById(Long examId) {
        return null;
    }
}
