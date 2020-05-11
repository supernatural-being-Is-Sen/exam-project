package com.coolyusen.exam.utils.page;

import java.util.List;
/**
 * @author 吴雨森
 * @data 2020/1/4 13:39
 */
public class Page<T> {

    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 每页显示记录条数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示的数据
     */
    private List<T> dataList;

    private Integer size;

    public Page(Integer currentPage,Integer pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public List<T> getDataList() {
        return dataList;
    }
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", dataList=" + dataList +
                '}';
    }
}
