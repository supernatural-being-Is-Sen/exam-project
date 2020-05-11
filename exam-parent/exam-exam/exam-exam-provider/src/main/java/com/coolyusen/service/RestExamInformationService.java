package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.exam.ExamInformationMapper;
import com.coolyusen.exam.pojo.exam.ExamInformation;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author 吴雨森
 * @data 2019/12/9
 */
@RestController
public class RestExamInformationService {

    @Resource
    private ExamInformationMapper examInformationMapper;


    /**
     * 根据考试信息的list批量添加考试信息
     * @param examInformations
     * @return
     */
    @RequestMapping(value = "addExamInformationByList",method = POST)
    public List<ExamInformation> addExamInformationByList(@RequestBody
                                                           List<ExamInformation> examInformations){
        //非空判断
        if (EmptyUtils.isEmpty(examInformations)) {
            throw new NullPointerException("The exam information list is not be null");
        }
        //进行批量添加
        this.examInformationMapper.addExamInformationByList(examInformations);
        return examInformations;
    }

    /**
     * 根据考试编号找到题目编号
     * @param examId
     * @return
     */
    @RequestMapping(value = "findSubjectIdByExamId",method = POST)
    public List<Long> findSubjectIdByExamId(@RequestParam("examId") Long examId){
        return this.examInformationMapper.findSubjectIdByExamId(examId);
    }

    /**
     * 根据考试编号找到考试题目信息
     * @param examId
     * @return
     */
    @RequestMapping(value = "findExamInformationByExamId",method = POST)
    public List<ExamInformation> findExamInformationByExamId(@RequestParam("examId") Long examId){
        return this.examInformationMapper.selectList(
            new QueryWrapper<ExamInformation>()
                .eq("exam_id",examId)
                .eq("exam_information_del",Constants.DoesItExist.NOT_DELETE)
        );
    }

    /**
     * 根据考试信息编号找到考试信息
     * @param id
     * @return
     */
    @RequestMapping(value = "findExamInformationById",method = POST)
    public ExamInformation findExamInformationById(@RequestParam("id") Long id){
        return this.examInformationMapper.selectOne(
                new QueryWrapper<ExamInformation>()
                .eq("id",id)
                .eq("exam_information_del",Constants.DoesItExist.NOT_DELETE)
        );
    }
}