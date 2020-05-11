package com.coolyusen.service;

import com.coolyusen.exam.pojo.curriculum.Chapter;
import com.coolyusen.exam.vo.CurriculumChapterVo;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
public interface ChapterService {

    /**
     * 按照阶段编号查找到所有的课程以及对应的章节
     * @param stageId 阶段编号
     * @return
     */
    Object findCurriculumChapterByStageId(Integer stageId);

    /**
     * 根据课程编号查找对应的章节
     * @param curriculum
     * @return
     */
    List<Chapter> getChapterByCurriculum(Integer curriculum);
}
