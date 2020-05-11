package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.test.TestSubjectMapper;
import com.coolyusen.exam.pojo.test.TestSubject;
import com.coolyusen.exam.utils.EmptyUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@RestController
public class RestTestSubjectService {

    @Resource
    private TestSubjectMapper testSubjectMapper;

    /**
     * 添加测试的题目
     * @param subjects
     * @return
     */
    @RequestMapping(value = "addTestSubjects",method = RequestMethod.POST)
    public List<TestSubject> addTestSubjects(@RequestBody List<TestSubject> subjects){
        //非空判断
        if(EmptyUtils.isEmpty(subjects)){
            return null;
        }
        this.testSubjectMapper.addTestSubjects(subjects);
        return subjects;
    }

    /**
     * 根据编号查找测试题目
     * @param testSubjectId
     * @return
     */
    @RequestMapping(value = "findTestSubjectById",method = RequestMethod.POST)
    public TestSubject findTestSubjectById(@RequestParam("testSubjectId") Long testSubjectId){
        return this.testSubjectMapper.selectOne(
                new QueryWrapper<TestSubject>()
                .eq("id",testSubjectId)
        );
    }

    /**
     * 根据测试编号查找题目编号
     * @param userTestId
     * @return
     */
    @RequestMapping(value = "findTestSubjectByUserTestId",method = RequestMethod.POST)
    public List<TestSubject> findTestSubjectByUserTestId(@RequestParam("userTestId") Long userTestId){
        return this.testSubjectMapper.selectList(
                new QueryWrapper<TestSubject>()
                .eq("user_test_id",userTestId)
        );
    }
}
