package com.coolyusen.exam.fallback.exam;

import com.coolyusen.exam.client.exam.RestExamResultClient;
import com.coolyusen.exam.pojo.exam.ExamResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/2/4
 */
@Component
public class ExamResultClientFallback implements RestExamResultClient {
    @Override
    public void addExamResultList(List<ExamResult> examResults) {

    }
}
