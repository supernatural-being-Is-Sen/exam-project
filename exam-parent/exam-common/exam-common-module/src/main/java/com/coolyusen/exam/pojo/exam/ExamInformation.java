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
public class ExamInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 考试编号
     */
    private Long examId;

    /**
     * 题目编号
     */
    private Long subjectId;

    /**
     * 是否存在
     */
    private Boolean examInformationDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Boolean getExamInformationDel() {
        return examInformationDel;
    }

    public void setExamInformationDel(Boolean examInformationDel) {
        this.examInformationDel = examInformationDel;
    }

    @Override
    public String toString() {
        return "ExamInformation{" +
        "id=" + id +
        ", examId=" + examId +
        ", subjectId=" + subjectId +
        ", examInformationDel=" + examInformationDel +
        "}";
    }
}
