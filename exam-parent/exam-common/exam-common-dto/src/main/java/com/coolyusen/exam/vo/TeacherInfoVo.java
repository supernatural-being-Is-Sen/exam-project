package com.coolyusen.exam.vo;

import java.io.Serializable;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
public class TeacherInfoVo extends UsersVo implements Serializable {

    //id
    private Long teacherId;

    //教师编号
    private String teacherNum;

    //职位
    private String positionName;

    //部门
    private String departmentName;


    @Override
    public String toString() {
        return "TeacherInfoVo {" +
                "userId=" + userId +
                ", nickName=" + nickName +
                ", username=" + username +
                ", email=" + email +
                ", wxUserId=" + wxUserId +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", idCard=" + idCard +
                ", cardType=" + cardType +
                ", userStatus=" + userStatus +
                ", role=" + role +
                ", teacherNum=" + teacherNum +
                ", positionName=" + positionName +
                ", departmentName=" + departmentName +
                "}";
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
