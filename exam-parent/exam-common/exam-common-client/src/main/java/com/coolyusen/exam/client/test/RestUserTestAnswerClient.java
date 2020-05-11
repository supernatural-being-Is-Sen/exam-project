package com.coolyusen.exam.client.test;

import com.coolyusen.exam.fallback.test.TestUserTestAnswerClientFallback;
import com.coolyusen.exam.pojo.test.UserTestAnswer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/3
 */
@FeignClient(value = "exam-test-provider",fallback = TestUserTestAnswerClientFallback.class)
public interface RestUserTestAnswerClient {

    /**
     * 批量添加用户的答案
     * @param userTestAnswers
     */
    @RequestMapping(value = "addUserTestAnswer",method = RequestMethod.POST)
    void addUserTestAnswer(@RequestBody List<UserTestAnswer> userTestAnswers);

    /**
     * 根据测试题目集合id找到所有的学生答案
     * @param testSubjectIdList
     * @return
     */
    @RequestMapping(value = "findUserTestAnswerByTestSubjectList",method = RequestMethod.POST)
    List<UserTestAnswer> findUserTestAnswerByTestSubjecIdtList(@RequestParam("testSubjectIdList") List<Long> testSubjectIdList);
}
