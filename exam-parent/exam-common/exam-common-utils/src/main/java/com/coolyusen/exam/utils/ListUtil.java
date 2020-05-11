package com.coolyusen.exam.utils;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@Component
public class ListUtil {

    /**
     * 按照索引截取集合
     * @param fromIndex 开始索引
     * @param toIndex   结束索引
     * @param interceptList 截取集合
     * @param <T>   泛型
     * @return 截取后的集合
     */
    public static <T> List<T> interceptList(int fromIndex,int toIndex,List<T> interceptList){
        if(EmptyUtils.isEmpty(interceptList)){
            throw new NullPointerException("This collection cannot be empty");
        }
        //最终返回结果
        List<T> newArrayList = Lists.newArrayList();
        if(interceptList.size() < toIndex){
            return interceptList;
        }else if (fromIndex >= toIndex){
            throw new IndexOutOfBoundsException("Subscript cannot be greater than length");
        }
        for (int i = fromIndex; i < toIndex; i++) {
            newArrayList.add(interceptList.get(i));
        }
        return newArrayList;
    }

    public static <T> List<T> newArrayList(){
        return new ArrayList<>();
    }

    /**
     * 过滤机和的其它属性
     * @param filterList 被过滤的list
     * @param field 属性编号
     * @param rClass 不被过滤的类型
     * @param <T> list类型
     * @param <R> 不被过滤类型泛型
     * @return 过滤后的list
     */
    /*public static <T,R> List<R> filterListField(List<T> filterList,Object field,Class<R> rClass){
        List<R> fieldList = ListUtil.newArrayList();
        if(EmptyUtils.isEmpty(filterList)){
            throw new NullPointerException("The filterList is not be null");
        }
        boolean flag = false;
        for (T t : filterList) {
            Class<T> aClass = (Class<T>) t.getClass();
            if(!flag){
                for (Field aClassField : aClass.getDeclaredFields()) {
                    if(aClassField.getName().equals(field)){
                        flag = true;
                    }
                }
            }
            if(!flag){
                throw new NullPointerException("The filterList field is null");
            }
            try {
                Field field1 =
                        aClass.getDeclaredField(String.valueOf(field));
                field1.setAccessible(true);
                fieldList.add((R)field1.get(field));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fieldList;
    }*/
}
