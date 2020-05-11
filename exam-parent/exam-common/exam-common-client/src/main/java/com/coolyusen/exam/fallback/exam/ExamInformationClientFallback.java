package com.coolyusen.exam.fallback.exam;

import com.coolyusen.exam.client.exam.RestExamInformationClient;
import com.coolyusen.exam.pojo.exam.ExamInformation;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/9
 */
@Component
public class ExamInformationClientFallback implements RestExamInformationClient {


    @Override
    public List<ExamInformation> addExamInformationByList(List<ExamInformation> examInformations) {
        return null;
    }

    @Override
    public List<Long> findSubjectIdByExamId(Long examId) {
        return null;
    }

    @Override
    public List<ExamInformation> findExamInformationByExamId(Long examId) {
        return null;
    }

    @Override
    public ExamInformation findExamInformationById(Long id) {
        return null;
    }

}
