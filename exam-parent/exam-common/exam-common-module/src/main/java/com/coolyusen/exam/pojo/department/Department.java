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
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门描述
     */
    private String departmentDetail;

    /**
     * 是否存在
     */
    private Boolean departmentDel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDetail() {
        return departmentDetail;
    }

    public void setDepartmentDetail(String departmentDetail) {
        this.departmentDetail = departmentDetail;
    }

    public Boolean getDepartmentDel() {
        return departmentDel;
    }

    public void setDepartmentDel(Boolean departmentDel) {
        this.departmentDel = departmentDel;
    }

    @Override
    public String toString() {
        return "Department{" +
        "id=" + id +
        ", departmentName=" + departmentName +
        ", departmentDetail=" + departmentDetail +
        ", departmentDel=" + departmentDel +
        "}";
    }
}
