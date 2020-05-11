package com.coolyusen.exam.fallback.exam;

import com.coolyusen.exam.client.exam.RestExamGradeClient;
import com.coolyusen.exam.pojo.exam.ExamGrade;
import com.coolyusen.exam.vo.ExamBaseInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/9
 */
@Component
public class ExamGradeClientFallback implements RestExamGradeClient {

    @Override
    public void addExamGrade(ExamGrade examGrade) {

    }

    @Override
    public List<ExamGrade> findExamGradeByGradeId(Long gradeId) {
        return null;
    }

    @Override
    public List<ExamBaseInfoVo> findExamBaseInfoByGradeId(Long gradeId) {
        return null;
    }
}
