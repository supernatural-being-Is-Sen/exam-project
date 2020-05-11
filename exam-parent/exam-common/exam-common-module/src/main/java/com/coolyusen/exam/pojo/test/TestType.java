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
public class TestType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 测试类型名称
     */
    private String testTypeName;

    /**
     * 描述
     */
    private String testTypeDetail;

    /**
     * 测试类型题数
     */
    private Integer testTypeCount;

    /**
     * 每道题分数
     */
    private Integer testScore;

    /**
     * 测试图片
     */
    private String testTypeImage;

    /**
     * 测试时间(分钟)
     */
    private Float testTime;

    /**
     * 是否存在
     */
    private Boolean testTypeDel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestTypeName() {
        return testTypeName;
    }

    public void setTestTypeName(String testTypeName) {
        this.testTypeName = testTypeName;
    }

    public String getTestTypeDetail() {
        return testTypeDetail;
    }

    public void setTestTypeDetail(String testTypeDetail) {
        this.testTypeDetail = testTypeDetail;
    }

    public Integer getTestTypeCount() {
        return testTypeCount;
    }

    public void setTestTypeCount(Integer testTypeCount) {
        this.testTypeCount = testTypeCount;
    }

    public Integer getTestScore() {
        return testScore;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }

    public String getTestTypeImage() {
        return testTypeImage;
    }

    public void setTestTypeImage(String testTypeImage) {
        this.testTypeImage = testTypeImage;
    }

    public Float getTestTime() {
        return testTime;
    }

    public void setTestTime(Float testTime) {
        this.testTime = testTime;
    }

    public Boolean getTestTypeDel() {
        return testTypeDel;
    }

    public void setTestTypeDel(Boolean testTypeDel) {
        this.testTypeDel = testTypeDel;
    }

    @Override
    public String toString() {
        return "TestType{" +
        "id=" + id +
        ", testTypeName=" + testTypeName +
        ", testTypeDetail=" + testTypeDetail +
        ", testTypeCount=" + testTypeCount +
        ", testScore=" + testScore +
        ", testTypeImage=" + testTypeImage +
        ", testTime=" + testTime +
        ", testTypeDel=" + testTypeDel +
        "}";
    }
}
