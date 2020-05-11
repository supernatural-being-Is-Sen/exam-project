package com.coolyusen.exam.mapper.vo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.vo.ExamBaseInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/1/21
 */
public interface ExamBaseInfoMapper extends BaseMapper<ExamBaseInfoVo> {

    /**
     * 根据班级编号查找考试基本信息
     * @param gradeId 班级编号
     * @return
     */
    List<ExamBaseInfoVo> findExamBaseInfoByGradeId(@Param("gradeId") Long gradeId);
}
