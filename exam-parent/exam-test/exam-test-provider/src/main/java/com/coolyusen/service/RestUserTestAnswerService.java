package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.test.UserTestAnswerMapper;
import com.coolyusen.exam.pojo.test.UserTestAnswer;
import com.coolyusen.exam.utils.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/3
 */
@RestController
public class RestUserTestAnswerService {

    @Autowired
    private UserTestAnswerMapper userTestAnswerMapper;

    /**
     * 批量添加用户答案
     * @param userTestAnswers
     */
    @RequestMapping(value = "addUserTestAnswer",method = RequestMethod.POST)
    public void addUserTestAnswer(@RequestBody List<UserTestAnswer> userTestAnswers){
        this.userTestAnswerMapper.addUserTestAnswer(userTestAnswers);
    }

    /**
     * 根据测试题目集合id找到所有的学生答案
     * @param testSubjectIdList
     * @return
     */
    @RequestMapping(value = "findUserTestAnswerByTestSubjectList",method = RequestMethod.POST)
    public List<UserTestAnswer> findUserTestAnswerByTestSubjecIdtList(@RequestParam("testSubjectIdList") List<Long> testSubjectIdList){
        //非空验证
        if(EmptyUtils.isEmpty(testSubjectIdList)){
            return null;
        }
        return this.userTestAnswerMapper.selectList(
                new QueryWrapper<UserTestAnswer>()
                .in("test_subject_id",testSubjectIdList)
        );
    }
}
