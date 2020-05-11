package com.coolyusen.file;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author 吴雨森
 * @data 2020/1/20
 */
public class FastDfsFile implements Serializable {

    /**
     * 文件名
     */
    private String name;

    /**
     * 内容
     */
    private byte[] content;

    /**
     * 文件扩展名
     */
    private String ext;

    /**
     * 加密
     */
    private String md5;

    /**
     * 作者
     */
    private String author;

    public FastDfsFile(String name,byte[] content,String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

    public FastDfsFile(String name, byte[] content, String ext, String md5, String author) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.md5 = md5;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "FastDfsFile{" +
                "name='" + name + '\'' +
                ", content=" + Arrays.toString(content) +
                ", ext='" + ext + '\'' +
                ", md5='" + md5 + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
