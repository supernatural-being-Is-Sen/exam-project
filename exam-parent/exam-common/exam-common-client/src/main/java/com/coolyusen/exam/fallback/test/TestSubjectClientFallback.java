package com.coolyusen.exam.fallback.test;

import com.coolyusen.exam.client.test.RestTestSubjectClient;
import com.coolyusen.exam.pojo.test.TestSubject;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@Component
public class TestSubjectClientFallback implements RestTestSubjectClient {

    @Override
    public List<TestSubject> addTestSubjects(List<TestSubject> subjects) {
        return null;
    }

    @Override
    public TestSubject findTestSubjectById(Long testSubjectId) {
        return null;
    }

    @Override
    public List<TestSubject> findTestSubjectByUserTestId(Long userTestId) {
        return null;
    }

}
