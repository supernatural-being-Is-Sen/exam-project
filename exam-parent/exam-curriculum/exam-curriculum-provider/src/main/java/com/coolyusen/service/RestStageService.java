package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.curriculum.StageMapper;
import com.coolyusen.exam.pojo.curriculum.Stage;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@RestController
public class RestStageService {

    @Resource
    private StageMapper stageMapper;

    /**
     * 根据阶段编号查找阶段
     * @param stageId
     * @return
     */
    @RequestMapping(value = "findStageById",method = RequestMethod.POST)
    public Stage findStageById(@RequestParam("stageId") Integer stageId){
        return this.stageMapper.selectOne(
                new QueryWrapper<Stage>()
                .eq("id",stageId)
                .eq("stage_del", Constants.DoesItExist.NOT_DELETE)
        );
    }
}
