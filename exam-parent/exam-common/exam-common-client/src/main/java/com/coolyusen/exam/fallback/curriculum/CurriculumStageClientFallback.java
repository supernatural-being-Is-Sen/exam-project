package com.coolyusen.exam.fallback.curriculum;

import com.coolyusen.exam.client.curriculum.RestCurriculumStageClient;
import com.coolyusen.exam.vo.CurriculumStageInfoVo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@Component
public class CurriculumStageClientFallback implements RestCurriculumStageClient {


    @Override
    public List<Integer> findCurriculumIdByStageId(Integer stageId) {
        return null;
    }

    @Override
    public List<CurriculumStageInfoVo> findCurriculumStageInfo(Integer curriculumSystemId, Integer curriculumId, Integer stageId, boolean groupFlag) {
        return null;
    }


}
