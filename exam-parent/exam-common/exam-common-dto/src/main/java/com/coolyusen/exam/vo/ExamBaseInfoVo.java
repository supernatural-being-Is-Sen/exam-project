package com.coolyusen.exam.vo;

import lombok.Data;

/**
 * @author 吴雨森
 * @data 2020/1/21
 */
@Data
public class ExamBaseInfoVo {

    /**
     * 考试编号
     */
    private Long examId;

    /**
     * 考试名
     */
    private String examName;

    /**
     * 发布教师编号
     */
    private Long userId;

    /**
     * 发布教师姓名
     */
    private String teacherName;

    /**
     * 班级编号
     */
    private Long gradeId;

    /**
     * 班级名称
     */
    private String gradeName;

    /**
     * 总题数
     */
    private Integer subjectCount;

    /**
     * 每道题分数
     */
    private Integer subjectScore;

    /**
     * 发布日期
     */
    private String examBeginTime;

    /**
     * 考试时间
     */
    private String examTime;

    /**
     * 考试描述
     */
    private String examDetail;
}
