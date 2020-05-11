package com.coolyusen.exam.client.user;

import com.coolyusen.exam.fallback.user.UsersClientFallback;
import com.coolyusen.exam.pojo.user.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author 吴雨森
 * @data 2019/11/22 20:55
 */
@FeignClient(name = "exam-users-provider",fallback = UsersClientFallback.class)
public interface RestUsersClient {

    /**
     * 依据用户邮箱查询用户
     * @param email
     * @return
     */
    @RequestMapping(value = "findUserByEmail",method = RequestMethod.POST)
    Users findUserByEmail(@RequestParam("email") String email);

    /**
     * 根据邮箱和密码查找用户
     * @return
     */
    @RequestMapping(value = "findUserByEmailAndPassword",method = RequestMethod.POST)
    Users findUserByEmailAndPassword(@RequestBody Users users);

    /**
     * 生成邮箱验证码token
     * @param
     * @return
     */
    @RequestMapping(value = "generateEmailVerificationCodeToken",method = RequestMethod.GET)
    String generateEmailVerificationCodeToken();

    /**
     * 依照邮箱修改密码
     * @param newPassword 新密码
     * @return
     */
    @RequestMapping(value = "updatePasswordByEmail",method = RequestMethod.POST)
    String updatePasswordByEmail(@RequestParam("email") String email,
                                 @RequestParam("newPassword") String newPassword);

    /**
     * 发送学生注册请求
     * @param users
     * @return
     */
    @RequestMapping(value = "sendRegistryStudentRequest",method = RequestMethod.POST)
    long[] sendRegistryStudentRequest(@RequestBody Users users);

    /**
     * 发送邮箱
     * @param emailVerificationCode
     */
    @RequestMapping(value = "sendVerificationCode",method = RequestMethod.POST)
    void sendVerificationCode(@RequestParam("emailVerificationCode") String[] emailVerificationCode);

    /**
     * 根据用户邮箱修改用户的基本信息
     * @param user 用户
     */
    @RequestMapping(value = "makeUserBaseInfoByEmail",method = RequestMethod.POST)
    void makeUserBaseInfoByEmail(@RequestBody Users user);

    /**
     * 根据用户编号list找到用户信息
     * @param usersIds
     * @return
     */
    @RequestMapping(value = "findUsersByIds",method = RequestMethod.POST)
    List<Users> findUsersByIds(@RequestParam("userIds") List<Long> usersIds);
}
