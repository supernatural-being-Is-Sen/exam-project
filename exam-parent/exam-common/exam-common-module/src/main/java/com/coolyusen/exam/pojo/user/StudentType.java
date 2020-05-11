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
public class StudentType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生类型编号
     */
    private Integer id;

    /**
     * 类型名称
     */
    private String typeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "StudentType{" +
        "id=" + id +
        ", typeName=" + typeName +
        "}";
    }
}
