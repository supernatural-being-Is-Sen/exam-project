package com.coolyusen.exam.client.subject;

import com.coolyusen.exam.fallback.subject.KnowledgeClientFallback;
import com.coolyusen.exam.pojo.subject.Knowledge;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@FeignClient(name = "exam-subject-provider",fallback = KnowledgeClientFallback.class)
public interface RestKnowledgeClient {

    /**
     * 依照章节查找对应的知识点
     * @param chapterId
     * @return
     */
    @RequestMapping(value = "findKnowledgeIdByChapterId",method = RequestMethod.POST)
    List<Long> findKnowledgeIdByChapterId(@RequestParam("chapterId") Long chapterId);

    /**
     * 根据章节编号集合查找知识点编号
     * @param chapterIdList
     * @return
     */
    @RequestMapping(value = "findKnowledgeIdByChapterList",method = RequestMethod.POST)
    List<Long> findKnowledgeIdByChapterList(@RequestParam("chapterIdList") List<Long> chapterIdList);

    /**
     * 查找所有知识点
     * @return
     */
    @RequestMapping(value = "findAllKnowledge",method = RequestMethod.GET)
    List<Knowledge> findAllKnowledge();
}
