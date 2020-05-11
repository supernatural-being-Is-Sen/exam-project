package com.coolyusen.exam.mapper.vo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.vo.CurriculumStageInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/2/8
 */
public interface CurriculumStageInfoVoMapper extends BaseMapper<CurriculumStageInfoVo> {

    /**
     * 查找课程体系阶段信息
     * @param curriculumSystemId
     * @param curriculumId
     * @param stageId
     * @param groupFlag
     * @return
     */
    List<CurriculumStageInfoVo> findCurriculumStageInfo(@Param("curriculumSystemId") Integer curriculumSystemId,
                                                        @Param("curriculumId") Integer curriculumId,
                                                        @Param("stageId") Integer stageId,
                                                        @Param("groupFlag") boolean groupFlag);
}
