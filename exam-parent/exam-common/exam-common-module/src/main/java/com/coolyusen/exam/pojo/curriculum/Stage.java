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
public class Stage implements Serializable {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 阶段名称
     */
    private String stageName;

    /**
     * 阶段详情
     */
    private String stageDetail;

    /**
     * 课时
     */
    private Integer classHour;

    /**
     * 排号
     */
    private Integer stageNum;

    /**
     * 课程体系编号
     */
    private Integer curriculumSystemId;

    /**
     * 是否存在
     */
    private Integer stageDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageDetail() {
        return stageDetail;
    }

    public void setStageDetail(String stageDetail) {
        this.stageDetail = stageDetail;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public Integer getStageNum() {
        return stageNum;
    }

    public void setStageNum(Integer stageNum) {
        this.stageNum = stageNum;
    }

    public Integer getCurriculumSystemId() {
        return curriculumSystemId;
    }

    public void setCurriculumSystemId(Integer curriculumSystemId) {
        this.curriculumSystemId = curriculumSystemId;
    }

    public Integer getStageDel() {
        return stageDel;
    }

    public void setStageDel(Integer stageDel) {
        this.stageDel = stageDel;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", stageName=" + stageName +
                ", stageDetail=" + stageDetail +
                ", classHour=" + classHour +
                ", stageNum=" + stageNum +
                ", curriculumSystemId=" + curriculumSystemId +
                ", stageDel=" + stageDel +
                "}";
    }
}
