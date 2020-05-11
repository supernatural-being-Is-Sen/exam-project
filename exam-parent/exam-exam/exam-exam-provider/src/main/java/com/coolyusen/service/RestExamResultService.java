package com.coolyusen.service;

import com.coolyusen.exam.mapper.exam.ExamResultMapper;
import com.coolyusen.exam.pojo.exam.ExamResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/2/4
 */
@RestController
public class RestExamResultService {

    @Autowired
    private ExamResultMapper examResultMapper;

    /**
     * 添加考试结果
     * @param examResults
     */
    @RequestMapping(value = "addExamResultList",method = RequestMethod.POST)
    void addExamResultList(@RequestBody List<ExamResult> examResults){
        this.examResultMapper.addExamResultList(examResults);
    }
}
