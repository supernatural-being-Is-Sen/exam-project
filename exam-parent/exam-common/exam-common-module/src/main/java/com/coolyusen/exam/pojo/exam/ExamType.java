package com.coolyusen.exam.pojo.exam;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class ExamType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 题目数量
     */
    private Integer subjectCount;

    /**
     * 每道题目分值
     */
    private Double subjectScore;

    /**
     * 考试时间(分)
     */
    private Integer examTime;

    /**
     * 描述
     */
    private String examDetail;

    /**
     * 是否删除
     */
    private Boolean examDel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(Integer subjectCount) {
        this.subjectCount = subjectCount;
    }

    public Double getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(Double subjectScore) {
        this.subjectScore = subjectScore;
    }

    public Integer getExamTime() {
        return examTime;
    }

    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }

    public String getExamDetail() {
        return examDetail;
    }

    public void setExamDetail(String examDetail) {
        this.examDetail = examDetail;
    }

    public Boolean getExamDel() {
        return examDel;
    }

    public void setExamDel(Boolean examDel) {
        this.examDel = examDel;
    }

    @Override
    public String toString() {
        return "ExamType{" +
        "id=" + id +
        ", typeName=" + typeName +
        ", subjectCount=" + subjectCount +
        ", subjectScore=" + subjectScore +
        ", examTime=" + examTime +
        ", examDetail=" + examDetail +
        ", examDel=" + examDel +
        "}";
    }
}
