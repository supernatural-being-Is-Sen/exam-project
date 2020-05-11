package com.coolyusen.exam.client.curriculum;

import com.coolyusen.exam.pojo.curriculum.CurriculumSystem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@FeignClient("exam-curriculum-provider")
public interface RestCurriculumSystemClient {

    /**
     * 根据课程体系编号查找课程体系
     * @param curriculumSystemId
     * @return
     */
    @RequestMapping(value = "findCurriculumSystemById",method = RequestMethod.POST)
    CurriculumSystem findCurriculumSystemById(@RequestParam("curriculumSystemId") Integer curriculumSystemId);
}
