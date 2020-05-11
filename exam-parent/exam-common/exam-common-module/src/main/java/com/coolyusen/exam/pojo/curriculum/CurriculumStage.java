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
public class CurriculumStage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 课程编号
     */
    private Integer curriculumId;

    /**
     * 阶段编号
     */
    private Integer stageId;

    /**
     * 是否存在
     */
    private Boolean curriculumStageDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public Boolean getCurriculumStageDel() {
        return curriculumStageDel;
    }

    public void setCurriculumStageDel(Boolean curriculumStageDel) {
        this.curriculumStageDel = curriculumStageDel;
    }

    @Override
    public String toString() {
        return "CurriculumStage{" +
                "id=" + id +
                ", curriculumId=" + curriculumId +
                ", stageId=" + stageId +
                ", curriculumStageDel=" + curriculumStageDel +
                "}";
    }
}
