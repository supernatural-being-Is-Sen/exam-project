package com.coolyusen.service;

import com.coolyusen.exam.vo.CurriculumStageInfoVo;

import java.util.List;
import java.util.Map;

/**
 * @author 吴雨森
 * @data 2020/2/8
 */
public interface CurriculumStageService {

    /**
     * 查找课程体系阶段信息
     * @param curriculumSystemId
     * @param curriculumId
     * @param stageId
     * @param groupFlag
     * @return
     */
    List<CurriculumStageInfoVo> findCurriculumStageInfo(Integer curriculumSystemId,
                                                        Integer curriculumId,
                                                        Integer stageId,
                                                        boolean groupFlag);
}
