package com.coolyusen.service;

import com.coolyusen.exam.pojo.subject.Subject;

import java.util.List;
import java.util.Map;

/**
 * @author 吴雨森
 * @data 2020/2/5
 */
public interface SubjectService {

    /**
     * 添加题目信息到es中
     */
    void addSubjectInfoToElasticsearch();

    /**
     * 搜索考试题目信息
     * @param searchMap
     * @return
     */
    Map<String,Object> selectSubjectInfo(Map<String,String> searchMap);

    /**
     * 根据章节和章节题数查找题目
     * @param chapterId
     * @param number
     * @param notSelect
     * @return
     */
    List<Subject> findRandomSubjectsByChapter(Integer chapterId,Integer number,Integer[] notSelect);
}
