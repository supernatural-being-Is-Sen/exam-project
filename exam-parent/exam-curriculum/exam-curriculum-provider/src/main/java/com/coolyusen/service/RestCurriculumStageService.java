package com.coolyusen.service;

import com.coolyusen.exam.mapper.curriculum.CurriculumStageMapper;
import com.coolyusen.exam.mapper.vo.CurriculumStageInfoVoMapper;
import com.coolyusen.exam.vo.CurriculumStageInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@RestController
public class RestCurriculumStageService {

    @Resource
    private CurriculumStageMapper curriculumStageMapper;

    @Autowired
    private CurriculumStageInfoVoMapper curriculumStageInfoVoMapper;

    /**
     * 根据阶段查询阶段课程编号
     * @param stageId
     * @return
     */
    @RequestMapping(value = "findCurriculumIdByStageId",method = RequestMethod.POST)
    public List<Integer> findCurriculumIdByStageId(@RequestParam("stageId") Integer stageId){
        return this.curriculumStageMapper.findCurriculumIdByStageId(stageId);
    }


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
                                                        @RequestParam(required = false) boolean groupFlag){
        return this.curriculumStageInfoVoMapper.findCurriculumStageInfo(curriculumSystemId,curriculumId,stageId,groupFlag);
    }
}
