package com.coolyusen.exam.fallback.curriculum;

import com.coolyusen.exam.client.curriculum.RestChapterClient;
import com.coolyusen.exam.pojo.curriculum.Chapter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@Component
public class ChapterClientFallback implements RestChapterClient {

    @Override
    public List<Chapter> findChapterListByCurriculumId(Integer curriculumId) {
        return null;
    }

    @Override
    public List<Long> findChapterIdListByCurriculumList(List<Integer> curriculumList) {
        return null;
    }

    @Override
    public List<Chapter> findAllChapter() {
        return null;
    }
}
