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
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目类型编号
     */
    private Integer subjectTypeId;

    /**
     * 知识点编号
     */
    private Long knowledgeId;

    /**
     * 解析
     */
    private String analysis;

    /**
     * 是否存在
     */
    private Boolean subjectDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Integer subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Boolean getSubjectDel() {
        return subjectDel;
    }

    public void setSubjectDel(Boolean subjectDel) {
        this.subjectDel = subjectDel;
    }

    @Override
    public String toString() {
        return "Subject{" +
        "id=" + id +
        ", subjectName=" + subjectName +
        ", subjectTypeId=" + subjectTypeId +
        ", knowledgeId=" + knowledgeId +
        ", analysis=" + analysis +
        ", subjectDel=" + subjectDel +
        "}";
    }
}
