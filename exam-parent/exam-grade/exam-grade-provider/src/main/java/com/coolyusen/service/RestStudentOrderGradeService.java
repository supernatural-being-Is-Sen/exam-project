package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.grade.StudentOrderGradeMapper;
import com.coolyusen.exam.pojo.grade.StudentOrderGrade;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@RestController
public class RestStudentOrderGradeService {

    @Resource
    private StudentOrderGradeMapper studentOrderGradeMapper;

    /**
     * 依照学生编号查找学生所在班级
     * @param studentId
     * @return
     */
    @RequestMapping(value = "findStudentOrderGradeByStudentId",method = RequestMethod.POST)
    public StudentOrderGrade findStudentOrderGradeByStudentId(@RequestParam("studentId") Long studentId){
        return this.studentOrderGradeMapper.selectOne(
                new QueryWrapper<StudentOrderGrade>()
                .eq("stu_id",studentId)
                .eq("student_order_grade_del", Constants.DoesItExist.NOT_DELETE)
        );
    }

    @RequestMapping(value = "addStudentOrderGrade",method = RequestMethod.POST)
    public Integer addStudentOrderGrade(@RequestBody StudentOrderGrade studentOrderGrade){
        return this.studentOrderGradeMapper.insert(studentOrderGrade);
    }

}
