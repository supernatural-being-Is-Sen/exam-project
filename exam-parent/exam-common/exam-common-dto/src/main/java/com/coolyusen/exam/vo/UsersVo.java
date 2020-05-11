package com.coolyusen.exam.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@Data
public class UsersVo implements Serializable {

    //用户编号
    protected Long userId;

    //用户名
    protected String nickName;

    //用户名
    protected String username;

    //邮箱
    protected String email;

    //微信号
    protected String wxUserId;

    //年龄
    protected Integer age;

    //性别
    protected Integer sex;

    //生日
    protected String birthday;

    //创建日期
    protected String createTime;

    //身份证号
    protected String idCard;

    //身份证类型
    protected Integer cardType;

    //用户状态
    protected Integer userStatus;

    //用户权限
    protected Integer role;

    //用户头像
    protected String imgUrl;
}
