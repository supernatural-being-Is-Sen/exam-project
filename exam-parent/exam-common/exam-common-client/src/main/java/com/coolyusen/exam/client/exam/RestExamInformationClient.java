package com.coolyusen.exam.client.exam;

import com.coolyusen.exam.fallback.exam.ExamInformationClientFallback;
import com.coolyusen.exam.pojo.exam.ExamInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/9
 */
@FeignClient(name = "exam-exam-provider",fallback = ExamInformationClientFallback.class)
public interface RestExamInformationClient {

    /**
     * 根据考试信息的list批量添加考试信息
     * @param examInformations
     * @return
     */
    @RequestMapping(value = "addExamInformationByList",method = RequestMethod.POST)
    List<ExamInformation> addExamInformationByList(@RequestBody List<ExamInformation> examInformations);

    /**
     * 根据考试编号题目编号
     * @param examId
     * @return
     */
    @RequestMapping(value = "findSubjectIdByExamId",method = RequestMethod.POST)
    List<Long> findSubjectIdByExamId(@RequestParam("examId") Long examId);

    /**
     * 根据考试编号找到考试题目信息
     * @param examId
     * @return
     */
    @RequestMapping(value = "findExamInformationByExamId",method = RequestMethod.POST)
    List<ExamInformation> findExamInformationByExamId(@RequestParam("examId") Long examId);

    /**
     * 根据考试信息编号找到考试信息
     * @param id
     * @return
     */
    @RequestMapping(value = "findExamInformationById",method = RequestMethod.POST)
    ExamInformation findExamInformationById(@RequestParam("id") Long id);
}
