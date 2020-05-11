package com.coolyusen.exam.mapper.subject;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.subject.Subject;
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
public interface SubjectMapper extends BaseMapper<Subject> {

    /**
     * 根据章节随机查找题目
     * @param chapterId
     * @param number
     * @param notSelect
     * @return
     */
    List<Subject> findRandomSubjectByChapter(@Param("chapterId") Integer chapterId,
                                             @Param("number") Integer number,
                                             Integer[] notSelect);
}
