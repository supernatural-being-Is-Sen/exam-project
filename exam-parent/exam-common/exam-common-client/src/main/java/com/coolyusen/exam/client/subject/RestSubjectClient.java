package com.coolyusen.exam.client.subject;

        import com.coolyusen.exam.fallback.subject.SubjectClientFallback;
        import com.coolyusen.exam.pojo.subject.Subject;
        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@FeignClient(name = "exam-subject-provider",fallback = SubjectClientFallback.class)
public interface RestSubjectClient {

    /**
     * 根据知识点编号查找所有存在的题目
     * @param knowledgeList 知识点编号
     * @return
     */
    @RequestMapping(value = "findSubjectByKnowledgeId",method = RequestMethod.POST)
    List<Subject> findSubjectByKnowledgeId(@RequestParam("knowledgeId") List<Long> knowledgeList);


    /**
     * 根据题目的id查找题目
     * @param subjectIdList
     * @return
     */
    @RequestMapping(value = "findSubjectById",method = RequestMethod.POST)
    List<Subject> findSubjectByIdList(@RequestBody List<Long> subjectIdList);


    /**
     * 根据章节随机查找题目
     * @param chapterId
     * @param number
     * @param notSelect
     * @return
     */
    @RequestMapping(value = "findRandomSubjectByChapter",method = RequestMethod.GET)
    List<Subject> findRandomSubjectByChapter(@RequestParam Integer chapterId,
                                                    @RequestParam Integer number,
                                                    @RequestParam Integer[] notSelect);
}
