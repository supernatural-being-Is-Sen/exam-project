package com.coolyusen.exam.pojo.test;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class CollectionSub implements Serializable {

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
     * 题目编号
     */
    private Long subjectId;

    /**
     * 是否存在
     */
    private Boolean collectionDel;


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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Boolean getCollectionDel() {
        return collectionDel;
    }

    public void setCollectionDel(Boolean collectionDel) {
        this.collectionDel = collectionDel;
    }

    @Override
    public String toString() {
        return "CollectionSub{" +
        "id=" + id +
        ", stuId=" + stuId +
        ", subjectId=" + subjectId +
        ", collectionDel=" + collectionDel +
        "}";
    }
}
