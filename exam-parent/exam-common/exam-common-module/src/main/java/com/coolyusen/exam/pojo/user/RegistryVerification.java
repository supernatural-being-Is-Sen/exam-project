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
public class RegistryVerification implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 班级编号
     */
    private Long gradeId;

    /**
     * 是否删除
     */
    private Boolean whetherToPass;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Boolean getWhetherToPass() {
        return whetherToPass;
    }

    public void setWhetherToPass(Boolean whetherToPass) {
        this.whetherToPass = whetherToPass;
    }

    @Override
    public String toString() {
        return "RegistryVerification{" +
        "id=" + id +
        ", userId=" + userId +
        ", gradeId=" + gradeId +
        ", whetherToPass=" + whetherToPass +
        "}";
    }
}
