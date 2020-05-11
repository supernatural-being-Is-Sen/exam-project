package com.coolyusen.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴雨森
 * @data 2019/12/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamInfoVo{

    /**
     * 题目数量
     */
    private Integer subjectCount;

    /**
     * 考试时间（秒）
     */
    private Integer examTime;

    /**
     * 每道题分数
     */
    private Double subjectScore;

    /**
     * 学生分数
     */
    private Double score;
}
