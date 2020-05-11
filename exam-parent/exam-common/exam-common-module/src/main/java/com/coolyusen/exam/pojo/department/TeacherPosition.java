package com.coolyusen.exam.pojo.department;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class TeacherPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 部门编号
     */
    private Integer departmentId;

    /**
     * 是否存在
     */
    private Boolean positionDel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Boolean getPositionDel() {
        return positionDel;
    }

    public void setPositionDel(Boolean positionDel) {
        this.positionDel = positionDel;
    }

    @Override
    public String toString() {
        return "TeacherPosition{" +
        "id=" + id +
        ", positionName=" + positionName +
        ", departmentId=" + departmentId +
        ", positionDel=" + positionDel +
        "}";
    }
}
