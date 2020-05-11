package com.coolyusen.controller;

import com.alibaba.fastjson.JSON;
import com.coolyusen.exam.common.Dto;
import com.coolyusen.exam.common.DtoUtil;
import com.coolyusen.exam.common.RedisUtils;
import com.coolyusen.exam.pojo.user.RegistryVerification;
import com.coolyusen.exam.pojo.user.Users;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import com.coolyusen.exam.utils.Encryption;
import com.coolyusen.exam.vo.*;
import com.coolyusen.service.RegistryVerificationService;
import com.coolyusen.service.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RegistryVerificationService registryVerificationService;

    /**
     * 根据邮箱和密码进行登录
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Dto login(@RequestBody Users users, HttpServletRequest request) {
        Users user = this.usersService.findUserByEmailAndPassword(users);
        //判断用户是否存在
        if (EmptyUtils.isEmpty(user))
            return DtoUtil.returnFail("邮箱或密码错误", Constants.CommonCode.EXCEPTION);
        //判断状态
        if (user.getUserStatus().equals(Constants.UserStatus.AUTHENTICATION)) {
            return DtoUtil.returnFail("此用户正在飞速认证中", Constants.CommonCode.USER_NO_LOGIN);
        } else if (user.getUserStatus().equals(Constants.UserStatus.FROZEN)) {
            return DtoUtil.returnFail("此用户已被停封", Constants.CommonCode.USER_NO_LOGIN);
        }
        //判断是否登录
        HttpSession session = request.getSession();
        /*if (EmptyUtils.isNotEmpty(session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER))) {
            return DtoUtil.returnFail("您的账号已登录,无需重复登录", Constants.CommonCode.EXCEPTION);
        }*/
        Object login = this.usersService.login(user);
        if (EmptyUtils.isEmpty(login)) {
            return DtoUtil.returnFail("登录失败", Constants.CommonCode.EXCEPTION);
        }
        //将用户信息存储到session中
        session.setAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER, login);
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS, login);
    }

    /**
     * 根据邮箱发送验证码
     * @param email 邮箱
     * @param registryRequestType 是否是学生注册请求类型
     * @return
     */
    @RequestMapping(value = "sendEmailVerificationCode",method = RequestMethod.POST)
    public Dto sendEmailVerificationCode(@RequestParam("email") String email,
                                         @RequestParam("registryRequestType") Boolean registryRequestType,
                                          HttpServletResponse response) throws MessagingException {
        if(registryRequestType){
            //判断是否出现重复操作
            Boolean repeat = this.usersService.findUserByEmail(email);
            if (EmptyUtils.isNotEmpty(repeat)) {
                if (repeat == false){
                    return DtoUtil.returnFail("此邮箱已经注册,正在迅速审核中", Constants.CommonCode.EXCEPTION);
                }
                else{
                    return DtoUtil.returnFail("此邮箱已被其他用户注册.", Constants.CommonCode.EXCEPTION);
                }
            }
        }
        try{
            //邮箱token
            String emailToken = Constants.Users.DEFAULT_VERIFICATION_CODE_SUFFIX + email;
            //判断是否存在重复发送
            if (this.redisUtils.get(emailToken) != null) {
                //清空之前的邮箱token
                this.redisUtils.delete(emailToken);
            }
            //发送验证码或且获取相关信息
            String[] emailVerificationCodeInfo =
                    this.usersService.sendVerificationCode(email);
            //将发送邮箱的token放入到cookie中
            response.addCookie(new Cookie(Constants.Users.EMAIL_TOKEN,emailToken));
        }catch (RuntimeException e){
            return DtoUtil.returnFail("发送失败",Constants.CommonCode.EXCEPTION);
        }
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS);
    }

    /**
     * 修改密码
     *
     * @param email       邮箱
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param verificationCode 验证码
     * @param request     request
     * @return
     */
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public Dto updatePassword(@RequestParam("email") String email,
                              @RequestParam("verificationCode") String verificationCode,
                              @RequestParam("oldPassword") String oldPassword,
                              @RequestParam("newPassword") String newPassword,
                              HttpServletRequest request) {
        HttpSession session = request.getSession();
        //判断用户是否登录
        if (EmptyUtils.isEmpty(session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER))) {
            return DtoUtil.returnFail("您还没有登录,请先登录", Constants.CommonCode.USER_NO_LOGIN);
        }
        //判断验证码是否输入错误
        //验证码
        String getVerificationCode = this.getEmailVerificationCode(request);
        //判断验证码是否过期
        if(verificationCode == null){
            return DtoUtil.returnFail("验证码以过期,请重新认证",
                    Constants.CommonCode.EXCEPTION);
        }
        //判断验证码是否输入正确
        if(!verificationCode.equals(getVerificationCode)){
            return DtoUtil.returnFail("验证码输入错误",
                    Constants.CommonCode.EXCEPTION);
        }
        //判断旧密码是否输入正确
        Users user = this.usersService.findUserInfoByEmail(email);
        if(!user.getPassword().equals(Encryption.getSha512(oldPassword))){
            return DtoUtil.returnFail("旧密码输入错误",
                    Constants.CommonCode.EXCEPTION);
        }
        //进行密码修改
        String password = this.usersService.updatePasswordByEmail(email, newPassword);
        if (EmptyUtils.isEmpty(password)) {
            return DtoUtil.returnFail("密码修改失败", Constants.CommonCode.EXCEPTION);
        }
        //取消用户登录状态
        session.removeAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        return DtoUtil.returnSuccess("修改成功,您的新密码为:" + password);
    }


    @RequestMapping(value = "get/{name}", method = RequestMethod.GET)
    public String getSession(@PathVariable String name, HttpSession session) {
        UsersVo usersVo = (UsersVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        return JSON.toJSONString(usersVo);
    }

    /**
     * 学生发送注册请求
     *
     * @param userGradeVo   学生注册信息
     * @return 信息
     */
    @RequestMapping(value = "sendRegistryStudentRequest", method = RequestMethod.POST)
    public Dto sendRegistryStudentRequest(@RequestBody StudentVerificationVo userGradeVo,
                                          HttpServletRequest request) {
        //判断是否出现重复操作
        Boolean repeat = this.usersService.findUserByEmail(userGradeVo.getEmail());
        if (EmptyUtils.isNotEmpty(repeat)) {
            if (repeat == false){
                return DtoUtil.returnFail("此邮箱已经注册,正在迅速审核中", Constants.CommonCode.EXCEPTION);
            }
            else{
                return DtoUtil.returnFail("此邮箱已被其他用户注册.", Constants.CommonCode.EXCEPTION);
            }
        }
        //验证码
        String verificationCode = this.getEmailVerificationCode(request);
        //判断验证码是否过期
        if(verificationCode == null){
            return DtoUtil.returnFail("验证码以过期,请重新认证",
                    Constants.CommonCode.EXCEPTION);
        }
        //判断验证码是否输入正确
        if(!userGradeVo.getVerificationCode().equals(verificationCode)){
            return DtoUtil.returnFail("verificationCodeError",
                    Constants.CommonCode.EXCEPTION);
        }
        //设置状态
        userGradeVo.setUserStatus(Constants.UserStatus.AUTHENTICATION);
        //设置权限
        userGradeVo.setRole(Constants.UserRole.STUDENT_ROLE);
        //设置存在
        userGradeVo.setUserDel(Constants.DoesItExist.NOT_DELETE_BOOLEAN);
        StudentRegistryVo registryVo = this.usersService.sendRegistryStudentRequest(userGradeVo);
        if (EmptyUtils.isEmpty(registryVo)) {
            return DtoUtil.returnFail("发送学生认证请求失败,请稍后重试",
                    Constants.CommonCode.EXCEPTION);
        }
        //添加班级记录
        RegistryVerification registryVerification = new RegistryVerification();
        registryVerification.setGradeId(registryVo.getGradeId());
        registryVerification.setUserId(registryVo.getUserId());
        registryVerification.setWhetherToPass(Constants.DoesItExist.NOT_DELETE_BOOLEAN);
        this.registryVerificationService.addRegistryVerification(registryVerification);
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS);
    }

    /**
     * 获取验证码
     * @param request
     * @return
     */
    private String getEmailVerificationCode(HttpServletRequest request){
        String verificationCode = null;
        //获取验证码cookie
        for (Cookie cookie : request.getCookies()) {
            if(cookie.getName().equals(Constants.Users.EMAIL_TOKEN)){
                verificationCode = this.redisUtils.get(cookie.getValue()).toString();
            }
        }
        return verificationCode;
    }

    /**
     * 用户注销
     * @param session
     * @return
     */
    @RequestMapping(value = "userCancellation", method = RequestMethod.GET)
    public Dto userCancellation(HttpSession session) {
        session.removeAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        return DtoUtil.returnSuccess("注销成功");
    }

    /**
     * 找到用户的基本信息
     * @param session
     * @return
     */
    @RequestMapping(value = "findUserInfo",method = RequestMethod.POST)
    public Dto findUserInfo(HttpSession session){
        UsersVo userInfo =
                (UsersVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        if(EmptyUtils.isEmpty(userInfo)){
            return DtoUtil.returnFail("亲,请登录",Constants.CommonCode.USER_NO_LOGIN);
        }
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,userInfo);
    }

    /**
     * 修改用户的基本信息
     * @param user 用户基本信息
     * @return
     */
    @RequestMapping(value = "makeUserBaseInfo",method = RequestMethod.POST)
    public Dto makeUserBaseInfo(@RequestBody Users user,HttpSession session){
        try{
            this.usersService.makeUserBaseInfo(user);
        }catch (RuntimeException e){
            return DtoUtil.returnFail("修改失败",Constants.CommonCode.EXCEPTION);
        }
        //修改用户信息的值
        UsersVo userInfo =
                (UsersVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        userInfo.setNickName(user.getNickName());
        userInfo.setAge(user.getAge());
        userInfo.setSex(user.getSex());
        if(EmptyUtils.isNotEmpty(user.getIdCard())){
            userInfo.setIdCard(user.getIdCard());
        }
        userInfo.setBirthday(user.getBirthday());
        //重新赋值到redis中
        session.setAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER,userInfo);
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS);
    }
}