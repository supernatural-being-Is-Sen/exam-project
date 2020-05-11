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
public class ExamGrade implements Serializable {

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
     * 班级编号
     */
    private Long gradeId;


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

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "ExamGrade{" +
        "id=" + id +
        ", examId=" + examId +
        ", gradeId=" + gradeId +
        "}";
    }
}
