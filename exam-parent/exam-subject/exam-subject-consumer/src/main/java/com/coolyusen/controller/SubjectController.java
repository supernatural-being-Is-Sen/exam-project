
package com.coolyusen.controller;

import com.coolyusen.exam.common.Dto;
import com.coolyusen.exam.common.DtoUtil;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 吴雨森
 * @date 2020/2/5
 */
@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "addSubjectInfoToElasticsearch",method = RequestMethod.GET)
    public Dto addSubjectInfoToElasticsearch(){
        this.subjectService.addSubjectInfoToElasticsearch();
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS);
    }

    /**
     * 搜索考试信息
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "searchSubject",method = RequestMethod.GET)
    public Dto searchSubject(@RequestParam(required = false) Map<String,String> searchMap){
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,
                this.subjectService.selectSubjectInfo(searchMap));
    }

    /**
     * 根据章节和章节题数查找题目
     * @param chapterId
     * @param number
     * @param notSelect
     * @return
     */
    @RequestMapping(value = "findSubjectsByChapterAndNum",method = RequestMethod.GET)
    public Dto findSubjectsByChapterAndNum(@RequestParam Integer chapterId,
                                           @RequestParam Integer number,
                                           @RequestParam(required = false) Integer[] notSelect){
        return DtoUtil.returnDataSuccess(subjectService.findRandomSubjectsByChapter(chapterId,number,notSelect));
    }

}
