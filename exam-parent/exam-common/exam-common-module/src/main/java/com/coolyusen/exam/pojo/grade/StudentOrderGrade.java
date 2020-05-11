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
public class StudentOrderGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 学生编号
     */
    private Long stuId;

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
    private Boolean studentOrderGradeDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
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

    public Boolean getStudentOrderGradeDel() {
        return studentOrderGradeDel;
    }

    public void setStudentOrderGradeDel(Boolean studentOrderGradeDel) {
        this.studentOrderGradeDel = studentOrderGradeDel;
    }

    @Override
    public String toString() {
        return "StudentOrderGrade{" +
        "id=" + id +
        ", stuId=" + stuId +
        ", gradeId=" + gradeId +
        ", beginTime=" + beginTime +
        ", endTime=" + endTime +
        ", studentOrderGradeDel=" + studentOrderGradeDel +
        "}";
    }
}
