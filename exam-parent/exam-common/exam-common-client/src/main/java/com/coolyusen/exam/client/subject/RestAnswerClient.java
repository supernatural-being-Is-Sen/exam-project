package com.coolyusen.exam.client.subject;

import com.coolyusen.exam.fallback.subject.AnswerClientFallback;
import com.coolyusen.exam.pojo.subject.Answer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@FeignClient(value = "exam-subject-provider",fallback = AnswerClientFallback.class)
public interface RestAnswerClient {

    /**
     * 根据题目编号查找对应的答案
     * @param subjectList 题目编号list
     * @return
     */
    @RequestMapping(value = "findAnswerBySubjectList",method = RequestMethod.POST)
    List<Answer> findAnswerBySubjectList(@RequestParam("subjectList") List<Long> subjectList);
}
