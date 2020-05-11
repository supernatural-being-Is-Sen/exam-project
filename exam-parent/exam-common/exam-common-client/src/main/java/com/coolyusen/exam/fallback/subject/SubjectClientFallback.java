package com.coolyusen.exam.fallback.subject;

import com.coolyusen.exam.client.subject.RestSubjectClient;
import com.coolyusen.exam.pojo.subject.Subject;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@Component
public class SubjectClientFallback implements RestSubjectClient {

    @Override
    public List<Subject> findSubjectByKnowledgeId(List<Long> knowledgeList) {
        return null;
    }

    @Override
    public List<Subject> findSubjectByIdList(List<Long> subjectIdList) {
        return null;
    }

    @Override
    public List<Subject> findRandomSubjectByChapter(Integer chapterId, Integer number, Integer[] notSelect) {
        return null;
    }

}
