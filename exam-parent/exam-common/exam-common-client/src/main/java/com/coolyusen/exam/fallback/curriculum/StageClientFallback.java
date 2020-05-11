package com.coolyusen.exam.fallback.curriculum;

import com.coolyusen.exam.client.curriculum.RestStageClient;
import com.coolyusen.exam.pojo.curriculum.Stage;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@Component
public class StageClientFallback implements RestStageClient {
    @Override
    public Stage findStageById(Integer stageId) {
        return null;
    }
}
