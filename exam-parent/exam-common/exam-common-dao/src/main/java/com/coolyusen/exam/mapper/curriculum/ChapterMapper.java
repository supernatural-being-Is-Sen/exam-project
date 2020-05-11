package com.coolyusen.exam.mapper.curriculum;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.curriculum.Chapter;
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
public interface ChapterMapper extends BaseMapper<Chapter> {

    /**
     * 根据课程编号集合查找章节编号
     * @param curriculumList
     * @return
     */
    List<Long> findChapterIdByCurriculumList(@Param("curriculumList") List<Integer> curriculumList);
}
