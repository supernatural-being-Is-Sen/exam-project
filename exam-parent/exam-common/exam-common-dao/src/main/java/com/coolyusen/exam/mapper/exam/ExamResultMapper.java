package com.coolyusen.exam.mapper.exam;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.exam.ExamResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public interface ExamResultMapper extends BaseMapper<ExamResult> {

    /**
     * 添加考试结果
     * @param examResults
     */
    void addExamResultList(@Param("examResults") List<ExamResult> examResults);
}
