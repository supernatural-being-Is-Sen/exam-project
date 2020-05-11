package com.coolyusen.exam.pojo.curriculum;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class Curriculum implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 课程名称
     */
    private String curriculumName;

    /**
     * 详情
     */
    private String curriculumDetail;

    /**
     * 是否存在
     */
    private Boolean curriculumDel;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumDetail() {
        return curriculumDetail;
    }

    public void setCurriculumDetail(String curriculumDetail) {
        this.curriculumDetail = curriculumDetail;
    }

    public Boolean getCurriculumDel() {
        return curriculumDel;
    }

    public void setCurriculumDel(Boolean curriculumDel) {
        this.curriculumDel = curriculumDel;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
        "id=" + id +
        ", curriculumName=" + curriculumName +
        ", curriculumDetail=" + curriculumName +
        ", curriculumDel=" + curriculumDel +
        "}";
    }
}
