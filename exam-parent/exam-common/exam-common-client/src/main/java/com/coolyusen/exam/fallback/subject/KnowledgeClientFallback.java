package com.coolyusen.exam.fallback.subject;

import com.coolyusen.exam.client.subject.RestKnowledgeClient;
import com.coolyusen.exam.pojo.subject.Knowledge;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@Component
public class KnowledgeClientFallback implements RestKnowledgeClient {

    @Override
    public List<Long> findKnowledgeIdByChapterId(Long chapterId) {
        return null;
    }

    @Override
    public List<Long> findKnowledgeIdByChapterList(List<Long> chapterIdList) {
        return null;
    }

    @Override
    public List<Knowledge> findAllKnowledge() {
        return null;
    }
}
