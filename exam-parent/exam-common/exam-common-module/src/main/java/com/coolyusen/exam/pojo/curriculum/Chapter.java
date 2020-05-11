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
public class Chapter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 章节描述
     */
    private String chapterDetail;

    /**
     * 课程编号
     */
    private Integer curriculumId;

    /**
     * 是否存在
     */
    private Boolean chapterDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDetail() {
        return chapterDetail;
    }

    public void setChapterDetail(String chapterDetail) {
        this.chapterDetail = chapterDetail;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Boolean getChapterDel() {
        return chapterDel;
    }

    public void setChapterDel(Boolean chapterDel) {
        this.chapterDel = chapterDel;
    }

    @Override
    public String toString() {
        return "Chapter{" +
        "id=" + id +
        ", chapterName=" + chapterName +
        ", chapterDetail=" + chapterDetail +
        ", curriculumId=" + curriculumId +
        ", chapterDel=" + chapterDel +
        "}";
    }
}
