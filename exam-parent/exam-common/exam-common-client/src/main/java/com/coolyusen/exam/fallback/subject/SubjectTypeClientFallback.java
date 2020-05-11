package com.coolyusen.exam.fallback.subject;

import com.coolyusen.exam.client.subject.RestSubjectTypeClient;
import com.coolyusen.exam.pojo.subject.SubjectType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@Component
public class SubjectTypeClientFallback implements RestSubjectTypeClient {
    @Override
    public List<SubjectType> findSubjectType() {
        return null;
    }
}
