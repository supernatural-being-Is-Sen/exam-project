package cn.kgc.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/1/4 13:44
 */
public class MyPage<T> {

    private Page<T> page;

    public MyPage(Page<T> page){
        this.page = page;
    }

    public void setIPage(List<T> pageList){
        this.page.setTotalPage(pageList.size() % this.page.getPageSize() == 0 ? pageList.size() / this.page.getPageSize() :
                pageList.size() / this.page.getPageSize() + 1);
        if(page.getTotalPage() == 0) {
            page.setTotalPage(1);
        }
        this.page.setDataList(this.paging(pageList,this.page.getCurrentPage(),this.page.getPageSize()));
        this.page.setSize(pageList.size());
    }

    public Integer getPageSize(){
        return this.page.getPageSize();
    }

    public Integer getCurrentPage(){
        return this.page.getCurrentPage();
    }

    public Integer getPages(){
        return this.page.getTotalPage();
    }

    public Integer getSize(){
        return this.page.getSize();
    }

    public List<T> getList(){
        return this.page.getDataList();
    }

    /**
     * 拆分
     * @param pageList
     * @param pageNum
     * @param pageSize
     * @return
     */
    private List<T> paging(List<T> pageList,int pageNum,int pageSize){
        return pageList.subList((pageNum - 1) * pageSize , pageSize);
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                '}';
    }
}
