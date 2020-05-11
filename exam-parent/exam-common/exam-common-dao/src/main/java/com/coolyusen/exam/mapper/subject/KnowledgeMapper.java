package com.coolyusen.exam.mapper.subject;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.subject.Knowledge;
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
public interface KnowledgeMapper extends BaseMapper<Knowledge> {

    /**
     * 依据章节编号找到对应的知识点
     * @param chapterId
     * @return
     */
    List<Long> findKnowledgeIdByChapterId(@Param("chapterId") Long chapterId);

    /**
     * 根据章节集合查找知识点编号
     * @param chapterIdList 章节集合编号
     * @return
     */
    List<Long> findKnowledgeIdByChapterList(@Param("chapterIdList") List<Long> chapterIdList);
}
