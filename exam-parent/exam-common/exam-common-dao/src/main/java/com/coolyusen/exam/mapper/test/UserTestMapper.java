package com.coolyusen.exam.mapper.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.test.UserTest;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public interface UserTestMapper extends BaseMapper<UserTest> {

    /**
     * 添加一条用户测试
     * @param userTest
     * @return
     */
    long addUserTest(UserTest userTest);

}
