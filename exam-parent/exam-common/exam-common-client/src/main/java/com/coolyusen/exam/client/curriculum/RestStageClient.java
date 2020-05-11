package com.coolyusen.exam.client.curriculum;

import com.coolyusen.exam.pojo.curriculum.Stage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@FeignClient("exam-curriculum-provider")
public interface RestStageClient {

    /**
     * 根据阶段编号查找阶段
     * @param stageId
     * @return
     */
    @RequestMapping(value = "findStageById",method = RequestMethod.POST)
    Stage findStageById(@RequestParam("stageId") Integer stageId);
}
