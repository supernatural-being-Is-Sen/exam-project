package com.coolyusen.exam.client.test;

import com.coolyusen.exam.fallback.test.TestSubjectClientFallback;
import com.coolyusen.exam.pojo.test.TestSubject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@FeignClient(name = "exam-test-provider",fallback = TestSubjectClientFallback.class)
public interface RestTestSubjectClient {

    /**
     * 添加测试的题目
     * @param subjects
     * @return
     */
    @RequestMapping(value = "addTestSubjects",method = RequestMethod.POST)
    List<TestSubject> addTestSubjects(@RequestBody List<TestSubject> subjects);

    /**
     * 根据编号查找测试题目
     * @param testSubjectId
     * @return
     */
    @RequestMapping(value = "findTestSubjectById",method = RequestMethod.POST)
    TestSubject findTestSubjectById(@RequestParam("testSubjectId") Long testSubjectId);

    /**
     * 根据测试编号查找题目测试题目
     * @param userTestId
     * @return
     */
    @RequestMapping(value = "findTestSubjectByUserTestId",method = RequestMethod.POST)
    List<TestSubject> findTestSubjectByUserTestId(@RequestParam("userTestId") Long userTestId);
}
