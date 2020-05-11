package com.coolyusen.exam.client.exam;

import com.coolyusen.exam.fallback.exam.ExamScoreClientFallback;
import com.coolyusen.exam.pojo.exam.ExamScore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/1/22
 */
@FeignClient(name = "exam-exam-provider",fallback = ExamScoreClientFallback.class)
public interface RestExamScoreClient {

    /**
     * 根据考试编号找到考试结果
     * @param userId
     * @return
     */
    @RequestMapping(value = "findExamScoreByUserId",method = RequestMethod.POST)
    List<ExamScore> findExamScoreByUserId(@RequestParam("userId") Long userId);

    /**
     * 添加一个考试结果
     * @param examScore
     */
    @RequestMapping(value = "addExamScore",method = RequestMethod.POST)
    void addExamScore(@RequestBody ExamScore examScore);
}
