package com.coolyusen.exam.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.user.Student;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public interface StudentMapper extends BaseMapper<Student> {

    long addStudent(Student student);
}
