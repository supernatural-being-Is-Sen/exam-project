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
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 教师编号
     */
    private String teacherNum;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 职位编号
     */
    private Integer teacherPositionId;

    /**
     * 是否存在
     */
    private Boolean teacherDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTeacherPositionId() {
        return teacherPositionId;
    }

    public void setTeacherPositionId(Integer teacherPositionId) {
        this.teacherPositionId = teacherPositionId;
    }

    public Boolean getTeacherDel() {
        return teacherDel;
    }

    public void setTeacherDel(Boolean teacherDel) {
        this.teacherDel = teacherDel;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "id=" + id +
        ", teacherNum=" + teacherNum +
        ", userId=" + userId +
        ", teacherPositionId=" + teacherPositionId +
        ", teacherDel=" + teacherDel +
        "}";
    }
}
