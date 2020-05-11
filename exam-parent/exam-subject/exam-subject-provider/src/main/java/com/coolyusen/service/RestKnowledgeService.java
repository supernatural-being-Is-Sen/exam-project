package com.coolyusen.service;

import com.coolyusen.exam.mapper.subject.KnowledgeMapper;
import com.coolyusen.exam.pojo.subject.Knowledge;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@RestController
public class RestKnowledgeService {

    @Resource
    private KnowledgeMapper knowledgeMapper;

    /**
     * 依照章节查找对应的知识点
     * @param chapterId
     * @return
     */
    @RequestMapping(value = "findKnowledgeIdByChapterId",method = RequestMethod.POST)
    public List<Long> findKnowledgeIdByChapterId(@RequestParam("chapterId") Long chapterId){
        return this.knowledgeMapper.findKnowledgeIdByChapterId(chapterId);
    }

    /**
     * 根据章节编号集合查找知识点编号
     * @param chapterIdList
     * @return
     */
    @RequestMapping(value = "findKnowledgeIdByChapterList",method = RequestMethod.POST)
    public List<Long> findKnowledgeIdByChapterList(@RequestParam("chapterIdList") List<Long> chapterIdList){
        return this.knowledgeMapper.findKnowledgeIdByChapterList(chapterIdList);
    }

    /**
     * 查找所有知识点
     * @return
     */
    @RequestMapping(value = "findAllKnowledge",method = RequestMethod.GET)
    public List<Knowledge> findAllKnowledge(){
        return this.knowledgeMapper.selectList(null);
    }
}
