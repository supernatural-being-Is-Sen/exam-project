package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.subject.SubjectMapper;
import com.coolyusen.exam.pojo.subject.Subject;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@RestController
public class RestSubjectService {


    @Resource
    private SubjectMapper subjectMapper;

    /**
     * 根据知识点编号查找所有存在的题目
     * @param knowledgeList 知识点编号
     * @return
     */
    @RequestMapping(value = "findSubjectByKnowledgeId",method = RequestMethod.POST)
    public List<Subject> findSubjectByKnowledgeId(@RequestParam("knowledgeId") List<Long> knowledgeList){
        if(EmptyUtils.isEmpty(knowledgeList)){
            return null;
        }
        return this.subjectMapper.selectList(
                new QueryWrapper<Subject>()
                .in("knowledge_id",knowledgeList)
                .eq("subject_del", Constants.DoesItExist.NOT_DELETE)
        );
    }

    /**
     * 根据题目的id查找题目
     * @param subjectIdList
     * @return
     */
    @RequestMapping(value = "findSubjectById",method = RequestMethod.POST)
    public List<Subject> findSubjectByIdList(@RequestBody List<Long> subjectIdList){
        return this.subjectMapper.selectList(
                new QueryWrapper<Subject>()
                .in("id",subjectIdList)
                .eq("subject_del",Constants.DoesItExist.NOT_DELETE)
        );
    }

    /**
     * 根据章节随机查找题目
     * @param chapterId
     * @param number
     * @param notSelect
     * @return
     */
    @RequestMapping(value = "findRandomSubjectByChapter",method = RequestMethod.GET)
    public List<Subject> findRandomSubjectByChapter(@RequestParam Integer chapterId,
                                                    @RequestParam Integer number,
                                                    @RequestParam(required = false) Integer[] notSelect) {
        if(notSelect.length == 0) {
            notSelect = null;
        }
        return this.subjectMapper.findRandomSubjectByChapter(chapterId,number,notSelect);
    }
}
