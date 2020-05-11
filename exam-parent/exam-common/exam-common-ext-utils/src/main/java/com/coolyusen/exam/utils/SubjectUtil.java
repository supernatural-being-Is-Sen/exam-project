package com.coolyusen.exam.utils;

import com.coolyusen.exam.pojo.subject.Answer;
import com.coolyusen.exam.pojo.subject.Subject;
import com.coolyusen.exam.pojo.subject.SubjectType;
import com.coolyusen.exam.vo.SubjectVo;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/8
 */
@Component
public class SubjectUtil {

    /**
     * 添加题目的信息
     * @param subjects
     * @param subjectType
     * @param subjectIdList
     */
    public void addSubjects(List<SubjectVo> subjectVos, List<Subject> subjects,
                            List<SubjectType> subjectType, List<Long> subjectIdList){
        //查找到所有的题目id
        for (Subject subject : subjects) {
            SubjectVo subjectVo = new SubjectVo();
            subjectVo.setSubjectId(subject.getId());
            BeanUtils.copyProperties(subject,subjectVo);
            //进行题目类型添加
            for (SubjectType type : subjectType) {
                //判断是否和题目类型名称相同
                if(type.getId().equals(subject.getSubjectTypeId())){
                    subjectVo.setSubjectTypeName(type.getSubjectTypeName());
                    break;
                }
            }
            subjectVo.setSubjectTypeId(subject.getSubjectTypeId());
            //进行判断
            subjectIdList.add(subject.getId());
            //将SubjectVo对象放入集合中
            subjectVos.add(subjectVo);
        }
    }

    /**
     * 根据题目vo和题目的id找到答案
     * @param subjectVos
     */
    public void addAnswerBySubjectIdList(List<Answer> answerList,
                                         List<SubjectVo> subjectVos){
        //题目答案
        List<Answer> answers;
        //进行题目答案添加
        for (SubjectVo subjectVo : subjectVos) {
            answers = Lists.newArrayList();
            for (Answer answer : answerList) {
                if(subjectVo.getSubjectId() == answer.getSubjectId()){
                    answers.add(answer);
                }
            }
            subjectVo.setAnswerList(answers);
        }
    }
}
