package com.coolyusen.exam.client.curriculum;

import com.coolyusen.exam.fallback.curriculum.ChapterClientFallback;
import com.coolyusen.exam.pojo.curriculum.Chapter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@FeignClient(value = "exam-curriculum-provider",fallback = ChapterClientFallback.class)
public interface RestChapterClient {

    /**
     * 根据课程编号查询章节编号
     * @param curriculumId
     * @return
     */
    @RequestMapping(value = "findChapterListByCurriculumId",method = RequestMethod.POST)
    List<Chapter> findChapterListByCurriculumId(@RequestParam("curriculumId") Integer curriculumId);

    /**
     * 根据课程编号查找章节编号
     * @param curriculumList
     * @return
     */
    @RequestMapping(value = "findChapterIdListByCurriculumList",method = RequestMethod.POST)
    List<Long> findChapterIdListByCurriculumList(@RequestParam("curriculumList") List<Integer> curriculumList);

    /**
     * 查找所有章节
     * @return
     */
    @RequestMapping(value = "findAllChapter",method = RequestMethod.GET)
    List<Chapter> findAllChapter();
}
