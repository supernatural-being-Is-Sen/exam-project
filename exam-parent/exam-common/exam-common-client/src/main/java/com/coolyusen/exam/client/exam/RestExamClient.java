package com.coolyusen.exam.client.exam;

import com.coolyusen.exam.fallback.exam.ExamClientFallback;
import com.coolyusen.exam.pojo.exam.Exam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@FeignClient(value = "exam-exam-provider",fallback = ExamClientFallback.class)
public interface RestExamClient {

    /**
     * 根据题目信息添加题目并返回主键
     * @param exam
     * @return
     */
    @RequestMapping(value = "addExam",method = RequestMethod.POST)
    Long addExam(@RequestBody Exam exam);

    /**
     * 考试考试编号找到考试信息
     * @param examId
     * @return
     */
    @RequestMapping(value = "findExamById",method = RequestMethod.POST)
    Exam findExamById(@RequestParam("examId") Long examId);
}
