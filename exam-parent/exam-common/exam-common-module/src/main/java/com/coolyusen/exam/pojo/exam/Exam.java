package com.coolyusen.exam.pojo.exam;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 开始时间
     */
    private String examBeginTime;

    /**
     * 结束时间
     */
    private String examEndTime;

    /**
     * 考试类型编号
     */
    private Integer examTypeId;

    /**
     * 考试描述
     */
    private String examDetail;

    /**
     * 教师编号
     */
    private Long userId;

    /**
     * 是否存在
     */
    private Integer examDel;

    public Exam(){}

    public Exam(String examName,String examDetail,String examEndTime) {
        this.examName = examName;
        this.examDetail = examDetail;
        this.examEndTime = examEndTime;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamBeginTime() {
        return examBeginTime;
    }

    public void setExamBeginTime(String examBeginTime) {
        this.examBeginTime = examBeginTime;
    }

    public String getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(String examEndTime) {
        this.examEndTime = examEndTime;
    }

    public Integer getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(Integer examTypeId) {
        this.examTypeId = examTypeId;
    }

    public String getExamDetail() {
        return examDetail;
    }

    public void setExamDetail(String examDetail) {
        this.examDetail = examDetail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getExamDel() {
        return examDel;
    }

    public void setExamDel(Integer examDel) {
        this.examDel = examDel;
    }

    @Override
    public String toString() {
        return "Exam{" +
        "id=" + id +
        ", examName=" + examName +
        ", examBeginTime=" + examBeginTime +
        ", examEndTime=" + examEndTime +
        ", examTypeId=" + examTypeId +
        ", examDetail=" + examDetail +
        ", userId=" + userId +
        ", examDel=" + examDel +
        "}";
    }
}
