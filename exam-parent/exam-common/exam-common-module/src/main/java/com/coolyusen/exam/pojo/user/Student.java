package com.coolyusen.exam.pojo.user;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 学生编号
     */
    private String stuNum;

    /**
     * 学生编号
     */
    private Long userId;

    /**
     * 类型编号
     */
    private Integer studentTypeId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStudentTypeId() {
        return studentTypeId;
    }

    public void setStudentTypeId(Integer studentTypeId) {
        this.studentTypeId = studentTypeId;
    }

    @Override
    public String toString() {
        return "Student{" +
        "id=" + id +
        ", stuNum=" + stuNum +
        ", userId=" + userId +
        ", studentTypeId=" + studentTypeId +
        "}";
    }
}
