package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.grade.TeacherOrderGradeMapper;
import com.coolyusen.exam.pojo.grade.TeacherOrderGrade;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@RestController
public class RestTeacherOrderGradeService {

    @Resource
    private TeacherOrderGradeMapper teacherOrderGradeMapper;

    /**
     * 根据教师编号查找教师所在班级
     * @param teacherId 教师编号
     * @return
     *
     */
    @RequestMapping(value = "findTeacherOrderGradeByTeacherId",method = RequestMethod.POST)
    public List<TeacherOrderGrade> findTeacherOrderGradeByTeacherId(@RequestParam("teacherId") Long teacherId){
        return this.teacherOrderGradeMapper.selectList(
                new QueryWrapper<TeacherOrderGrade>()
                .eq("teacher_id",teacherId)
                .eq("teacher_order_grade_del", Constants.DoesItExist.NOT_DELETE)
        );
    }
}
