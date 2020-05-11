package com.coolyusen.service;

import com.coolyusen.exam.pojo.test.UserTest;
import com.coolyusen.exam.pojo.test.UserTestAnswer;
import com.coolyusen.exam.vo.SubjectVo;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
public interface UserTestService {

    /**
     * 根据章节编号和测试类型的查找对应的题目
     * @return
     */
    Object[] studentSelfTest(Long chapterId, Integer testTypeId, Long stuId);

    /**
     * 学生提交测试
     * @param userTestAnswerList 测试集合
     */
    UserTest studentSubmitTest(List<UserTestAnswer> userTestAnswerList, Long stuId);

    /**
     * 找到学生测试的信息
     * @param testSubjectId 测试题目的编号
     * @return 测试信息
     */
    Object[] studentTestInfo(Long testSubjectId,Long userTestId);
}
