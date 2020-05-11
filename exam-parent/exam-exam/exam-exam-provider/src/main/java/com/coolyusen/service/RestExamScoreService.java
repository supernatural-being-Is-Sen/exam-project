package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.exam.ExamScoreMapper;
import com.coolyusen.exam.pojo.exam.ExamScore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/1/22
 */
@RestController
public class RestExamScoreService {

    @Resource
    private ExamScoreMapper examScoreMapper;

    /**
     * 根据考试编号找到考试结果
     * @param userId
     * @return
     */
    @RequestMapping(value = "findExamScoreByUserId",method = RequestMethod.POST)
    public List<ExamScore> findExamScoreByUserId(@RequestParam("userId") Long userId){
        return this.examScoreMapper.selectList(
                new QueryWrapper<ExamScore>()
                .eq("user_id",userId)
        );
    }

    /**
     * 添加一个考试结果
     * @param examScore
     */
    @RequestMapping(value = "addExamScore",method = RequestMethod.POST)
    public void addExamScore(@RequestBody ExamScore examScore){
        this.examScoreMapper.insert(examScore);
    }
}
