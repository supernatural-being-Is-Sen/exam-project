package com.coolyusen.exam.client.curriculum;

import com.coolyusen.exam.fallback.curriculum.CurriculumClientFallback;
import com.coolyusen.exam.pojo.curriculum.Curriculum;
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
@FeignClient(name = "exam-curriculum-provider",fallback = CurriculumClientFallback.class)
public interface RestCurriculumClient {

    /**
     * 根据课程编号查询课程
     * @param curriculumIdList 课程集合编号
     * @return 课程集合
     */
    @RequestMapping(value = "findCurriculumById",method = RequestMethod.POST)
    List<Curriculum> findCurriculumByIdList(@RequestBody List<Integer> curriculumIdList);
}
