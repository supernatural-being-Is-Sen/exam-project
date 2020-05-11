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
public class ReadNoticeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 公告编号
     */
    private Long noticeId;

    /**
     * 是否以读
     */
    private Boolean whetherRead;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Boolean getWhetherRead() {
        return whetherRead;
    }

    public void setWhetherRead(Boolean whetherRead) {
        this.whetherRead = whetherRead;
    }

    @Override
    public String toString() {
        return "ReadNoticeRecord{" +
        "id=" + id +
        ", userId=" + userId +
        ", noticeId=" + noticeId +
        ", whetherRead=" + whetherRead +
        "}";
    }
}
