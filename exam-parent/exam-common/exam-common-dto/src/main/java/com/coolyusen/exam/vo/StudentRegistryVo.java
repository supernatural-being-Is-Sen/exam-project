package com.coolyusen.exam.vo;

import lombok.Data;

/**
 * @author 吴雨森
 * @data 2019/11/26
 */
@Data
public class StudentRegistryVo {

    /**
     *     用户编号
     */
    private Long userId;

    /**
     * 学生编号
     */
    private Long stuId;

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
     * 密码
     */
    private String password;

    /**
     * 年级编号
     */
    private Long gradeId;
}
