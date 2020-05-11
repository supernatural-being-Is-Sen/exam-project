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
public class ExamResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 考试信息编号
     */
    private Long examInformationId;

    /**
     * 用户答案
     */
    private Object userAnswer;


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

    public Long getExamInformationId() {
        return examInformationId;
    }

    public void setExamInformationId(Long examInformationId) {
        this.examInformationId = examInformationId;
    }

    public Object getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(Object userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
        "id=" + id +
        ", userId=" + userId +
        ", examInformationId=" + examInformationId +
        ", userAnswer=" + userAnswer +
        "}";
    }
}
