package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.department.TeacherPositionMapper;
import com.coolyusen.exam.pojo.department.TeacherPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@RestController
public class RestTeacherPositionService {

    @Resource
    private TeacherPositionMapper teacherPositionMapper;


    /**
     * 依据编号查找到职位
     * @param teacherPositionId 职位编号
     * @return 职位
     */
    @RequestMapping(value = "findTeacherPositionById",method = RequestMethod.POST)
    public TeacherPosition findTeacherPositionById(@RequestParam("teacherPositionId") Integer teacherPositionId){
        return this.teacherPositionMapper.selectOne(
                new QueryWrapper<TeacherPosition>().eq("id",teacherPositionId)
        );
    }
}
