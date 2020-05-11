package com.coolyusen.exam.mapper.exam;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.exam.Exam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public interface ExamMapper extends BaseMapper<Exam> {

    /**
     * 添加一条考试并返回主键id
     * @param exam
     * @return
     */
    int addExam(Exam exam);
}
