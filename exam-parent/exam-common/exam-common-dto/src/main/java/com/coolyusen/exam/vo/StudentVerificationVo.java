package com.coolyusen.exam.vo;

import com.coolyusen.exam.pojo.user.Users;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 吴雨森
 * @data 2019/12/12
 */
@Data
public class StudentVerificationVo extends Users implements Serializable {

    /**
     * 班级编号
     */
    private Long gradeId;

    /**
     * 验证码
     */
    private String verificationCode;
}
