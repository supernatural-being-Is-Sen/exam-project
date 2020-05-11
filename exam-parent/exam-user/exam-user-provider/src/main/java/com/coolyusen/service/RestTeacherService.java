package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.user.TeacherMapper;
import com.coolyusen.exam.pojo.user.Teacher;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@RestController
public class RestTeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @RequestMapping(value = "findTeacherByUserId",method = RequestMethod.POST)
    public Teacher findTeacherByUserId(@RequestParam("userId") Long userId){
        return this.teacherMapper.selectOne(
                new QueryWrapper<Teacher>().eq("user_id",userId)
        );
    }

    /**
     * 根据教师编号集合找到教师信息
     * @param teacherIds
     * @return
     */
    @RequestMapping(value = "findTeacherByTeacherIds",method = RequestMethod.POST)
    public List<Teacher> findTeacherByTeacherIds(@RequestParam("teacherIds") List<Long> teacherIds){
        if(teacherIds.isEmpty()) {
            return null;
        }
        return this.teacherMapper.selectList(
            new QueryWrapper<Teacher>()
                .in("id",teacherIds)
                .eq("teacher_del", Constants.DoesItExist.NOT_DELETE)
        );
    }
}
