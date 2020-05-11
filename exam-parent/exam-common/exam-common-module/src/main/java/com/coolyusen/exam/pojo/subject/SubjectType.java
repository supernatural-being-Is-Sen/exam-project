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
public class SubjectType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 类型名称
     */
    private String subjectTypeName;

    /**
     * 是否存在
     */
    private Boolean subjectTypeDel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    public Boolean getSubjectTypeDel() {
        return subjectTypeDel;
    }

    public void setSubjectTypeDel(Boolean subjectTypeDel) {
        this.subjectTypeDel = subjectTypeDel;
    }

    @Override
    public String toString() {
        return "SubjectType{" +
        "id=" + id +
        ", subjectTypeName=" + subjectTypeName +
        ", subjectTypeDel=" + subjectTypeDel +
        "}";
    }
}
