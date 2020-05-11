package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.user.StudentMapper;
import com.coolyusen.exam.pojo.user.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@RestController
public class RestStudentService {

    @Resource
    private StudentMapper studentMapper;


    @RequestMapping(value = "findStudentByUserId",method = RequestMethod.POST)
    public Student findStudentByUserId(@RequestParam("userId") Long userId){
        return this.studentMapper.selectOne(new QueryWrapper<Student>()
        .eq("user_id",userId));
    }

    @RequestMapping(value = "addStudent",method = RequestMethod.POST)
    public long[] addStudent(@RequestBody Student student){
        return new long[]{this.studentMapper.addStudent(student),student.getId()};
    }
}
