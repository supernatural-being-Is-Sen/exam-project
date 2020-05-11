package com.coolyusen.exam.mapper.curriculum;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.curriculum.CurriculumStage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
public interface CurriculumStageMapper extends BaseMapper<CurriculumStage> {

    /**
     * 依照阶段编号查询课程编号
     * @param stageId
     * @return
     */
    List<Integer> findCurriculumIdByStageId(@Param("stageId") Integer stageId);
}
