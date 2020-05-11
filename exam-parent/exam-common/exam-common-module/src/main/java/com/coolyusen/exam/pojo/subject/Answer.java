package com.coolyusen.exam.pojo.subject;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Object id;

    /**
     * 题目编号
     */
    private Long subjectId;

    /**
     * 答案
     */
    private String answer;

    /**
     * 答案索引
     */
    private Integer answerIndex;

    /**
     * 是否为正确答案
     */
    private Boolean boolAnswer;

    /**
     * 是否存在
     */
    private Boolean answerDel;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(Integer answerIndex) {
        this.answerIndex = answerIndex;
    }

    public Boolean getBoolAnswer() {
        return boolAnswer;
    }

    public void setBoolAnswer(Boolean boolAnswer) {
        this.boolAnswer = boolAnswer;
    }

    public Boolean getAnswerDel() {
        return answerDel;
    }

    public void setAnswerDel(Boolean answerDel) {
        this.answerDel = answerDel;
    }

    @Override
    public String toString() {
        return "Answer{" +
        "id=" + id +
        ", subjectId=" + subjectId +
        ", answer=" + answer +
        ", answerIndex=" + answerIndex +
        ", boolAnswer=" + boolAnswer +
        ", answerDel=" + answerDel +
        "}";
    }
}
