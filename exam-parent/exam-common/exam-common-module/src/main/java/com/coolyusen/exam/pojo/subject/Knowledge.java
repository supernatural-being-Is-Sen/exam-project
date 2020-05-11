package com.coolyusen.exam.pojo.subject;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class Knowledge implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 知识点名称
     */
    private String knowledgeName;

    /**
     * 描述
     */
    private String knowledgeDetail;

    /**
     * 章节编号
     */
    private Long chapterId;

    /**
     * 是否存在
     */
    private Boolean knowledgeDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public String getKnowledgeDetail() {
        return knowledgeDetail;
    }

    public void setKnowledgeDetail(String knowledgeDetail) {
        this.knowledgeDetail = knowledgeDetail;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Boolean getKnowledgeDel() {
        return knowledgeDel;
    }

    public void setKnowledgeDel(Boolean knowledgeDel) {
        this.knowledgeDel = knowledgeDel;
    }

    @Override
    public String toString() {
        return "Knowledge{" +
        "id=" + id +
        ", knowledgeName=" + knowledgeName +
        ", knowledgeDetail=" + knowledgeDetail +
        ", chapterId=" + chapterId +
        ", knowledgeDel=" + knowledgeDel +
        "}";
    }
}
