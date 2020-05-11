package com.coolyusen.exam.pojo.base;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class UserImage implements Serializable {

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
     * 图片地址
     */
    private String imgUrl;

    /**
     * 图片类型.0:用户头像
     */
    private Integer imageType;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 是否存在
     */
    private Integer imgDel;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getImageType() {
        return imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getImgDel(){
        return imgDel;
    }

    public void setImgDel(Integer imgDel){
        this.imgDel = imgDel;
    }

    @Override
    public String toString() {
        return "ExamImage{" +
                "id=" + id +
                ", userId=" + userId +
                ", imgUrl=" + imgUrl +
                ", imageType=" + imageType +
                ", createTime=" + createTime +
                ", imgDel" + imgDel +
                "}";
    }
}
