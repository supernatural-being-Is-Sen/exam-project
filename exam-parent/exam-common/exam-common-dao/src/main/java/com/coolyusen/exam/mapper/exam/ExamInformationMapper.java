package com.coolyusen.exam.mapper.exam;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.exam.ExamInformation;
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
public interface ExamInformationMapper extends BaseMapper<ExamInformation> {

    /**
     * 根据考试信息的list批量添加考试信息
     * @param examInformations
     * @return
     */
    void addExamInformationByList(List<ExamInformation> examInformations);

    /**
     * 根据考试编号找到题目编号
     * @param examId
     * @return
     */
    List<Long> findSubjectIdByExamId(@Param("examId") Long examId);
}
