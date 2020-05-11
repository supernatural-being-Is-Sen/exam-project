package com.coolyusen.exam.vo;

import com.coolyusen.exam.pojo.subject.Answer;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/9
 */
@Data
public class SubjectVo implements Serializable {

    /**
     * 题目编号
     */
    protected Long subjectId;

    /**
     * 题目名称
     */
    protected String subjectName;

    /**
     * 知识点编号
     */
    protected Long knowledgeId;

    /**
     * 题目类型编号
     */
    protected Integer subjectTypeId;

    /**
     * 题目类型
     */
    protected String subjectTypeName;

    /**
     *  题目解析
     */
    protected String analysis;

    /**
     *  题目答案
     */
    protected List<Answer> answerList;

    /**
     * 测试id
     */
    private Long userTestId;

    /**
     * 测试题目编号
     */
    private Long testSubjectId;

    /**
     * 考试编号
     */
    private Long examId;

    /**
     * 考试信息编号
     */
    private Long examInformationId;

    /**
     * 学生答案
     */
    private Object[] stuAnswer;

    /**
     * 是否正确
     */
    private Boolean correct;

}
