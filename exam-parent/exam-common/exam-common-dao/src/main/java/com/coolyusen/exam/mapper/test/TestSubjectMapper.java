package com.coolyusen.exam.mapper.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.test.TestSubject;
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
public interface TestSubjectMapper extends BaseMapper<TestSubject> {

    /**
     * 批量添加题目
     * @param subjects
     * @return
     */
    int addTestSubjects(List<TestSubject> subjects);
}
