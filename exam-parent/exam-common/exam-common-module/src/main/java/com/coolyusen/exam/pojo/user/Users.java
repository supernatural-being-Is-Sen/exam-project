package com.coolyusen.exam.pojo.user;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信
     */
    private String wxUserId;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 1.男 2.女
     */
    private Integer sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 创建日期
     */
    private String createTime;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 身份证类型 1.身份证;2.护照
     */
    private Integer cardType;

    /**
     * 用户身份
     */
    private Integer userStatus;

    /**
     * 用户权限
     */
    private Integer role;

    /**
     * 是否删除
     */
    private Boolean userDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(String wxUserId) {
        this.wxUserId = wxUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBithday(String birthday) {
        this.birthday = birthday;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getUserDel() {
        return userDel;
    }

    public void setUserDel(Boolean userDel) {
        this.userDel = userDel;
    }

    @Override
    public String toString() {
        return "Users{" +
        "id=" + id +
        ", nickName=" + nickName +
        ", username=" + username +
        ", email=" + email +
        ", wxUserId=" + wxUserId +
        ", password=" + password +
        ", age=" + age +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", createTime=" + createTime +
        ", idCard=" + idCard +
        ", cardType=" + cardType +
        ", userStatus=" + userStatus +
        ", role=" + role +
        ", userDel=" + userDel +
        "}";
    }
}
