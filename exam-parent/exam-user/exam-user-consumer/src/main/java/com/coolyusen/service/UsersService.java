package com.coolyusen.service;

import com.coolyusen.exam.pojo.user.Users;
import com.coolyusen.exam.vo.StudentRegistryVo;
import com.coolyusen.exam.vo.StudentVerificationVo;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
public interface UsersService {

    /**
     * 根据邮箱和密码查询用户信息
     * @return Dto
     */
    Users findUserByEmailAndPassword(Users users);

    /**
     * 登录
     * @param users
     * @return
     */
    Object login(Users users);

    /**
     * 依据邮箱修改密码
     * @param email 邮箱
     * @param newPassword 新密码
     * @return 新密码
     */
    String updatePasswordByEmail(String email,String newPassword);

    /**
     * 发送注册学生请求
     * @param userGradeVo
     * @return
     */
    StudentRegistryVo sendRegistryStudentRequest(StudentVerificationVo userGradeVo);

    /**
     * 依照邮箱查找用户信息
     * @param email
     * @return
     */
    Boolean findUserByEmail(String email);

    /**
     * 根据邮箱发送验证码
     * @param email 邮箱
     */
    String[] sendVerificationCode(String email) throws MessagingException;

    /**
     * 修改用户的基本信息
     * @param user
     */
    void makeUserBaseInfo(Users user);

    /**
     * 根据用户邮箱找到用户信息
     * @param email
     * @return
     */
    Users findUserInfoByEmail(String email);
}
