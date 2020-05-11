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
public class CurriculumSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 体系名称
     */
    private String curriculumSystemName;

    /**
     * 体系描述
     */
    private String curriculumSystemDetail;

    /**
     * 是否存在
     */
    private Boolean curriculumSystemDel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurriculumSystemName() {
        return curriculumSystemName;
    }

    public void setCurriculumSystemName(String curriculumSystemName) {
        this.curriculumSystemName = curriculumSystemName;
    }

    public String getCurriculumSystemDetail() {
        return curriculumSystemDetail;
    }

    public void setCurriculumSystemDetail(String curriculumSystemDetail) {
        this.curriculumSystemDetail = curriculumSystemDetail;
    }

    public Boolean getCurriculumSystemDel() {
        return curriculumSystemDel;
    }

    public void setCurriculumSystemDel(Boolean curriculumSystemDel) {
        this.curriculumSystemDel = curriculumSystemDel;
    }

    @Override
    public String toString() {
        return "CurriculumSystem{" +
        "id=" + id +
        ", curriculumSystemName=" + curriculumSystemName +
        ", curriculumSystemDetail=" + curriculumSystemDetail +
        ", curriculumSystemDel=" + curriculumSystemDel +
        "}";
    }
}
