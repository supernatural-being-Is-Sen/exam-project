package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.exam.ExamGradeMapper;
import com.coolyusen.exam.mapper.vo.ExamBaseInfoMapper;
import com.coolyusen.exam.pojo.exam.ExamGrade;
import com.coolyusen.exam.vo.ExamBaseInfoVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/9
 */
@RestController
public class RestExamGradeService {

    @Resource
    private ExamGradeMapper examGradeMapper;

    @Resource
    private ExamBaseInfoMapper examBaseInfoMapper;

    /**
     * 添加一条考试班级信息
     * @param examGrade 考试班级对象
     */
    @RequestMapping(value = "addExamGrade",method = RequestMethod.POST)
    public void addExamGrade(@RequestBody ExamGrade examGrade){
        this.examGradeMapper.insert(examGrade);
    }

    /**
     * 根据班级编号找到考试信息
     * @return
     */
    @RequestMapping(value = "findExamGradeByGradeId",method = RequestMethod.POST)
    public List<ExamGrade> findExamGradeByGradeId(@RequestParam("gradeId") Long gradeId){
        return this.examGradeMapper.selectList(
                new QueryWrapper<ExamGrade>()
                .eq("grade_id",gradeId)
        );
    }

    /**
     * 根据年级编号找到考试基本信息
     * @param gradeId
     * @return
     */
    @RequestMapping(value = "findExamBaseInfoByGradeId",method = RequestMethod.POST)
    public List<ExamBaseInfoVo> findExamBaseInfoByGradeId(@RequestParam("gradeId") Long gradeId){
        return this.examBaseInfoMapper.findExamBaseInfoByGradeId(gradeId);
    }
}