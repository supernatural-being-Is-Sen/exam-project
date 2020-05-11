package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.curriculum.ChapterMapper;
import com.coolyusen.exam.pojo.curriculum.Chapter;
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
public class RestChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    /**
     * 根据课程编号查询章节编号
     * @param curriculumId
     * @return
     */
    @RequestMapping(value = "findChapterListByCurriculumId",method = RequestMethod.POST)
    public List<Chapter> findChapterListByCurriculumId(@RequestParam("curriculumId") Integer curriculumId){
        return this.chapterMapper.selectList(
                new QueryWrapper<Chapter>()
                .eq("curriculum_id",curriculumId)
        );
    }

    /**
     * 根据课程编号查找章节编号
     * @param curriculumList
     * @return
     */
    @RequestMapping(value = "findChapterIdListByCurriculumList",method = RequestMethod.POST)
    public List<Long> findChapterIdListByCurriculumList(@RequestParam("curriculumList") List<Integer> curriculumList){
        return this.chapterMapper.findChapterIdByCurriculumList(curriculumList);
    }

    /**
     * 查找所有章节
     * @return
     */
    @RequestMapping(value = "findAllChapter",method = RequestMethod.GET)
    public List<Chapter> findAllChapter(){
        return this.chapterMapper.selectList(null);
    }
}
