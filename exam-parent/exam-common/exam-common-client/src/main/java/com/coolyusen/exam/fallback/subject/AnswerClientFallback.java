package com.coolyusen.exam.fallback.subject;

import com.coolyusen.exam.client.subject.RestAnswerClient;
import com.coolyusen.exam.pojo.subject.Answer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@Component
public class AnswerClientFallback implements RestAnswerClient {

    @Override
    public List<Answer> findAnswerBySubjectList(List<Long> subjectList) {
        return null;
    }
}
