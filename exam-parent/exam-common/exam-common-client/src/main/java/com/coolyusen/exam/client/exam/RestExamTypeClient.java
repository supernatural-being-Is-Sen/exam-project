package com.coolyusen.exam.client.exam;

import com.coolyusen.exam.fallback.exam.ExamTypeClientFallback;
import com.coolyusen.exam.pojo.exam.ExamType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@FeignClient(value = "exam-exam-provider",fallback = ExamTypeClientFallback.class)
public interface RestExamTypeClient {

    /**
     * 查找所有的考试类型
     * @return
     */
    @RequestMapping(value = "findExamType",method = RequestMethod.GET)
    List<ExamType> findExamType();


    /**
     * 根据考试类型编号查找考试类型
     * @param examTypeId
     * @return
     */
    @RequestMapping(value = "findExamTypeById",method = RequestMethod.POST)
    ExamType findExamTypeById(@RequestParam("examTypeId") Integer examTypeId);
}
