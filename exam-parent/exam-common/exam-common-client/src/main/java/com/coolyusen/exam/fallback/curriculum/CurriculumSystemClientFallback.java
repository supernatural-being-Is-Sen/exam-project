package com.coolyusen.exam.fallback.curriculum;

import com.coolyusen.exam.client.curriculum.RestCurriculumSystemClient;
import com.coolyusen.exam.pojo.curriculum.CurriculumSystem;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@Component
public class CurriculumSystemClientFallback implements RestCurriculumSystemClient {

    @Override
    public CurriculumSystem findCurriculumSystemById(Integer curriculumSystemId) {
        return null;
    }

}
