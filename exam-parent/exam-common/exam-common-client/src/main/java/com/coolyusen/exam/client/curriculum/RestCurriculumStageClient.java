package com.coolyusen.exam.client.curriculum;

import com.coolyusen.exam.fallback.curriculum.CurriculumStageClientFallback;
import com.coolyusen.exam.vo.CurriculumStageInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@FeignClient(name = "exam-curriculum-provider",fallback = CurriculumStageClientFallback.class)
public interface RestCurriculumStageClient {


    /**
     * 根据阶段查询阶段课程
     * @param stageId
     * @return
     */
    @RequestMapping(value = "findCurriculumIdByStageId",method = RequestMethod.POST)
    List<Integer> findCurriculumIdByStageId(@RequestParam("stageId") Integer stageId);


    /**
     * 查找课程体系阶段信息
     * @param curriculumSystemId
     * @param curriculumId
     * @param stageId
     * @param groupFlag 是否分组
     * @return
     */
    @RequestMapping(value = "findCurriculumStageInfo",method = RequestMethod.GET)
    List<CurriculumStageInfoVo> findCurriculumStageInfo(@RequestParam(required = false) Integer curriculumSystemId,
                                                        @RequestParam(required = false) Integer curriculumId,
                                                        @RequestParam(required = false) Integer stageId,
                                                        @RequestParam(required = false) boolean groupFlag);
}
