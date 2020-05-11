package com.coolyusen.exam.pojo.grade;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 班级名称
     */
    private String gradeName;

    /**
     * 阶段编号
     */
    private Integer stageId;

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 是否存在
     */
    private Boolean gradeDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getGradeDel() {
        return gradeDel;
    }

    public void setGradeDel(Boolean gradeDel) {
        this.gradeDel = gradeDel;
    }

    @Override
    public String toString() {
        return "Grade{" +
        "id=" + id +
        ", gradeName=" + gradeName +
        ", stageId=" + stageId +
        ", beginTime=" + beginTime +
        ", endTime=" + endTime +
        ", gradeDel=" + gradeDel +
        "}";
    }
}
