package com.coolyusen.exam.vo;

import java.io.Serializable;

/**
 * @author 吴雨森
 * @data 2019/11/23 19:17
 */
public class StudentInfoVo extends UsersVo implements Serializable {


    //id
    private Long stuId;

    //学生编号
    private String stuNum;

    //学生类型
    private String typeName;

    /**
     * 班级编号
     */
    private Long gradeId;

    //班级名称
    private String gradeName;

    //班级开始时间
    private String beginTime;

    //结束时间
    private String endTime;

    //阶段编号
    private Integer stageId;

    //阶段名称
    private String stageName;

    //课程体系编号
    private Integer curriculumSystemId;

    //课程体系名称
    private String curriculumName;

    @Override
    public String toString() {
        return "StudentInfoVo{" +
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
                ", stuNum=" + stuNum +
                ", stuId=" + stuId +
                ", typeName=" + typeName +
                ", gradeId=" + gradeId +
                ", gradeName" + gradeName +
                ", beginTime" + beginTime +
                ", endTime" + endTime +
                ", stageId" + stageId +
                "stageName" + stageName +
                "curriculumSystemId" + curriculumSystemId +
                "curriculumName" + curriculumName +
                "}";
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Integer getCurriculumSystemId() {
        return curriculumSystemId;
    }

    public void setCurriculumSystemId(Integer curriculumSystemId) {
        this.curriculumSystemId = curriculumSystemId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }
}
