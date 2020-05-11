package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.exam.ExamMapper;
import com.coolyusen.exam.pojo.exam.Exam;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@RestController
public class RestExamService {

    @Resource
    private ExamMapper examMapper;

    /**
     * 根据题目信息添加题目并返回主键
     * @param exam
     * @return
     */
    @RequestMapping(value = "addExam",method = RequestMethod.POST)
    public Long addExam(@RequestBody Exam exam){
        if(EmptyUtils.isEmpty(exam)){
            return null;
        }
        this.examMapper.addExam(exam);
        return exam.getId();
    }

    /**
     * 考试考试编号找到考试信息
     * @param examId
     * @return
     */
    @RequestMapping(value = "findExamById",method = RequestMethod.POST)
    public Exam findExamById(@RequestParam("examId") Long examId){
        return this.examMapper.selectOne(
                new QueryWrapper<Exam>()
                .eq("id",examId)
                .eq("exam_del", Constants.DoesItExist.NOT_DELETE)
        );
    }
}