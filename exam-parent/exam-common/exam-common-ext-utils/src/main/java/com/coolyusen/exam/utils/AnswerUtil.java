package com.coolyusen.exam.utils;

import com.coolyusen.exam.pojo.subject.Answer;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/2/1
 */
public class AnswerUtil {

    /**
     * 过滤错误答案
     * @param answerList 答案集合
     * @return
     */
    public static List<Answer> filterErrorAnswer(List<Answer> answerList){
        //返回的正确list
        List<Answer> correctAnswer = ListUtil.newArrayList();
        for (Answer answer : answerList) {
            if(answer.getBoolAnswer().equals(true)){
                correctAnswer.add(answer);
            }
        }
        return correctAnswer;
    }
}
