package com.coolyusen.exam.vo;

import com.coolyusen.exam.pojo.curriculum.Chapter;
import lombok.Data;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@Data
public class CurriculumChapterVo {

    //课程名称
    private String curriculumName;

    //课程的所有章节
    List<Chapter> chapterList;
}