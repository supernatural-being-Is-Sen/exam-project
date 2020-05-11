package com.coolyusen.service;

import com.coolyusen.exam.pojo.grade.Grade;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
public interface GradeService {

    /**
     * 无条件查找所有存在班级
     * @return
     */
    List<Grade> findGradeAll();
}
