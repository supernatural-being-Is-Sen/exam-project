package com.coolyusen.exam.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coolyusen.exam.pojo.user.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 依照邮箱修改密码
     * @param email 邮箱
     * @param newPassword 新密码
     * @return
     */
    @Update("update users set password = #{newPassword} where email = #{email}")
    int updatePasswordByEmail(@Param("email") String email,
                                  @Param("newPassword") String newPassword);

    /**
     * 添加一个用户并返回主键id
     * @param users
     * @return
     */
    long addUser(Users users);

    /**
     * 根据用户邮箱修改用户的基本信息
     * @param user
     */
    void makeUserBaseInfoByEmail(Users user);
}
