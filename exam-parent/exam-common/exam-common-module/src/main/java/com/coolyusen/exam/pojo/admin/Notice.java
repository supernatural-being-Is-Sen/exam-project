package com.coolyusen.exam.pojo.admin;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String context;

    /**
     * 公告是否删除
     */
    private Boolean noticeDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Boolean getNoticeDel() {
        return noticeDel;
    }

    public void setNoticeDel(Boolean noticeDel) {
        this.noticeDel = noticeDel;
    }

    @Override
    public String toString() {
        return "Notice{" +
        "id=" + id +
        ", title=" + title +
        ", context=" + context +
        ", noticeDel=" + noticeDel +
        "}";
    }
}
