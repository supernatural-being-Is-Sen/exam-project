package com.coolyusen.exam.fallback.exam;

import com.coolyusen.exam.client.exam.RestExamTypeClient;
import com.coolyusen.exam.pojo.exam.Exam;
import com.coolyusen.exam.pojo.exam.ExamType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@Component
public class ExamTypeClientFallback implements RestExamTypeClient {

    @Override
    public List<ExamType> findExamType() {
        return null;
    }

    @Override
    public ExamType findExamTypeById(Integer examTypeId) {
        return null;
    }
}
