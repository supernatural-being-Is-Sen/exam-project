package com.coolyusen.exam.pojo.grade;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class TeacherOrderGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 教师编号
     */
    private Long teacherId;

    /**
     * 班级编号
     */
    private Long gradeId;

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 是否存在
     */
    private Boolean teacherOrderGradeDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
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

    public Boolean getTeacherOrderGradeDel() {
        return teacherOrderGradeDel;
    }

    public void setTeacherOrderGradeDel(Boolean teacherOrderGradeDel) {
        this.teacherOrderGradeDel = teacherOrderGradeDel;
    }

    @Override
    public String toString() {
        return "TeacherOrderGrade{" +
        "id=" + id +
        ", teacherId=" + teacherId +
        ", gradeId=" + gradeId +
        ", beginTime=" + beginTime +
        ", endTime=" + endTime +
        ", teacherOrderGradeDel=" + teacherOrderGradeDel +
        "}";
    }
}
