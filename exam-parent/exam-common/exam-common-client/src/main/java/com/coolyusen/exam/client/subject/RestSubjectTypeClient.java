package com.coolyusen.exam.client.subject;

import com.coolyusen.exam.fallback.subject.SubjectTypeClientFallback;
import com.coolyusen.exam.pojo.subject.SubjectType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@FeignClient(name = "exam-subject-provider",fallback = SubjectTypeClientFallback.class)
public interface RestSubjectTypeClient {

    /**
     * 找到所有的题目类型
     * @return
     */
    @RequestMapping(value = "findSubjectType",method = RequestMethod.GET)
    List<SubjectType> findSubjectType();
}
