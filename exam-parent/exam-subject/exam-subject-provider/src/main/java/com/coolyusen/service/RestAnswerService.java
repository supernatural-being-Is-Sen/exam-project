package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.subject.AnswerMapper;
import com.coolyusen.exam.pojo.subject.Answer;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@RestController
public class RestAnswerService {

    @Resource
    private AnswerMapper answerMapper;

    /**
     * 根据题目编号查找对应的答案
     * @param subjectList 题目编号list
     * @return
     */
    @RequestMapping(value = "findAnswerBySubjectList",method = RequestMethod.POST)
    public List<Answer> findAnswerBySubjectList(@RequestParam("subjectList") List<Long> subjectList){
        //非空判断
        if(subjectList.isEmpty()){
            return null;
        }
        return this.answerMapper.selectList(
                new QueryWrapper<Answer>()
                .in("subject_id",subjectList)
                .eq("answer_del", Constants.DoesItExist.NOT_DELETE)
        );
    }
}
