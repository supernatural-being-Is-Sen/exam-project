package com.coolyusen.service.impl;

import com.coolyusen.exam.client.curriculum.RestCurriculumStageClient;
import com.coolyusen.exam.vo.CurriculumStageInfoVo;
import com.coolyusen.service.CurriculumStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/2/8
 */
@Service
public class CurriculumStageServiceImpl implements CurriculumStageService {

    @Autowired
    private RestCurriculumStageClient restCurriculumStageClient;

    @Override
    public List<CurriculumStageInfoVo> findCurriculumStageInfo(Integer curriculumSystemId, Integer curriculumId, Integer stageId, boolean groupFlag) {
        return this.restCurriculumStageClient.findCurriculumStageInfo(curriculumSystemId,curriculumId,stageId,groupFlag);
    }
}
