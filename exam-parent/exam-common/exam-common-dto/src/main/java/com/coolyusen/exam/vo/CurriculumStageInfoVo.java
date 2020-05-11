package com.coolyusen.exam.vo;

import java.io.Serializable;

/**
 * @author 吴雨森
 * @data 2020/2/8
 */
public class CurriculumStageInfoVo implements Serializable {

    /**
     * 课程体系编号
     */
    private Integer curriculumSystemId;

    /**
     * 课程体系名
     */
    private String curriculumSystemName;

    /**
     * 课程体系描述
     */
    private String curriculumSystemDetail;

    /**
     * 阶段编号
     */
    private Integer stageId;

    /**
     * 阶段名
     */
    private String stageName;

    /**
     * 阶段描述
     */
    private String stageDetail;

    /**
     * 课时
     */
    private Integer classHour;

    /**
     * 课程编号
     */
    private Integer curriculumId;

    /**
     * 课程名
     */
    private String curriculumName;

    /**
     * 课程描述
     */
    private String curriculumDetail;


    public Integer getCurriculumSystemId() {
        return curriculumSystemId;
    }

    public void setCurriculumSystemId(Integer curriculumSystemId) {
        this.curriculumSystemId = curriculumSystemId;
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

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
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

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
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

    @Override
    public String toString() {
        return "CurriculumStageInfoVo{" +
                "curriculumSystemId=" + curriculumSystemId +
                ", curriculumSystemName='" + curriculumSystemName + '\'' +
                ", curriculumSystemDetail='" + curriculumSystemDetail + '\'' +
                ", stageId=" + stageId +
                ", stageName='" + stageName + '\'' +
                ", stageDetail='" + stageDetail + '\'' +
                ", classHour=" + classHour +
                ", curriculumId=" + curriculumId +
                ", curriculumName='" + curriculumName + '\'' +
                ", curriculumDetail='" + curriculumDetail + '\'' +
                '}';
    }
}
