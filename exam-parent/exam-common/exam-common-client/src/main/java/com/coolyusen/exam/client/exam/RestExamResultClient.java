package com.coolyusen.exam.client.exam;

import com.coolyusen.exam.fallback.exam.ExamResultClientFallback;
import com.coolyusen.exam.pojo.exam.ExamResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/2/4
 */
@FeignClient(value = "exam-exam-provider",fallback = ExamResultClientFallback.class)
public interface RestExamResultClient {

    /**
     * 添加考试结果
     * @param examResults
     */
    @RequestMapping(value = "addExamResultList",method = RequestMethod.POST)
    void addExamResultList(@RequestBody List<ExamResult> examResults);
}
