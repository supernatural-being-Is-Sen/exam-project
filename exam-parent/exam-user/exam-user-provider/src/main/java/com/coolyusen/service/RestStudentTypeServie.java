package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.user.StudentTypeMapper;
import com.coolyusen.exam.pojo.user.StudentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@RestController
public class RestStudentTypeServie {

    @Autowired
    private StudentTypeMapper studentTypeMapper;

    @RequestMapping(value = "findStudentTypeByStudentId",method = RequestMethod.POST)
    public StudentType findStudentTypeByStudentId(@RequestParam("studentId") Integer studentId){
        return this.studentTypeMapper.selectOne(
                new QueryWrapper<StudentType>()
                .eq("id",studentId)
        );
    }
}
