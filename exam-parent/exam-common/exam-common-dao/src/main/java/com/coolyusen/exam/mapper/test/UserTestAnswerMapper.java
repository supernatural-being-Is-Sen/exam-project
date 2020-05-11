package com.coolyusen.exam.mapper.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.test.UserTestAnswer;
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
public interface UserTestAnswerMapper extends BaseMapper<UserTestAnswer> {

    /**
     * 批量添加用户测试答案
     * @param userTestAnswers
     */
    void addUserTestAnswer(@Param("userTestAnswer") List<UserTestAnswer> userTestAnswers);
}
