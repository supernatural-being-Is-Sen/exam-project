package com.coolyusen.exam.fallback.test;

import com.coolyusen.exam.client.test.RestUserTestAnswerClient;
import com.coolyusen.exam.pojo.test.UserTestAnswer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/16
 */
@Component
public class TestUserTestAnswerClientFallback implements RestUserTestAnswerClient {
    @Override
    public void addUserTestAnswer(List<UserTestAnswer> userTestAnswers) {

    }

    @Override
    public List<UserTestAnswer> findUserTestAnswerByTestSubjecIdtList(List<Long> testSubjectIdList) {
        return null;
    }
}
