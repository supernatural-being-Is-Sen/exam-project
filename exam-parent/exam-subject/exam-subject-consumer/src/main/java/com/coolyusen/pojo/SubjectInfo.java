package com.coolyusen.pojo;

import com.coolyusen.exam.pojo.subject.Answer;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/2/7
 */
@Document(indexName = "subject_info",type = "subject")
public class SubjectInfo {

    /**
     * 题目编号
     */
    @Id
    private Long subjectId;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目类型编号
     */
    private Integer subjectTypeId;

    /**
     * 题目类型
     */
    private String subjectTypeName;

    /**
     *  题目解析
     */
    private String analysis;

    /**
     * 知识点编号
     */
    private Long knowledgeId;

    /**
     * 知识点名称
     */
    private String knowledgeName;

    /**
     * 章节编号
     */
    private Long chapterId;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 课程体系编号
     */
    private Long curriculumSystemId;

    /**
     * 课程体系名
     */
    private String curriculumSystemName;

    /**
     * 课程体系描述
     */
    private String curriculumSystemDetail;

    /**
     * 阶段编号
     */
    private Integer stageId;

    /**
     * 阶段名
     */
    private String stageName;

    /**
     * 阶段描述
     */
    private String stageDetail;

    /**
     * 课时
     */
    private Integer classHour;

    /**
     * 课程编号
     */
    private Integer curriculumId;

    /**
     * 课程名
     */
    private String curriculumName;

    /**
     * 课程描述
     */
    private String curriculumDetail;

    /**
     *  题目答案
     */
    private List<Answer> answerList;


    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Integer subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Long getCurriculumSystemId() {
        return curriculumSystemId;
    }

    public void setCurriculumSystemId(Long curriculumSystemId) {
        this.curriculumSystemId = curriculumSystemId;
    }

    public String getCurriculumSystemName() {
        return curriculumSystemName;
    }

    public void setCurriculumSystemName(String curriculumSystemName) {
        this.curriculumSystemName = curriculumSystemName;
    }

    public String getCurriculumSystemDetail() {
        return curriculumSystemDetail;
    }

    public void setCurriculumSystemDetail(String curriculumSystemDetail) {
        this.curriculumSystemDetail = curriculumSystemDetail;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageDetail() {
        return stageDetail;
    }

    public void setStageDetail(String stageDetail) {
        this.stageDetail = stageDetail;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumDetail() {
        return curriculumDetail;
    }

    public void setCurriculumDetail(String curriculumDetail) {
        this.curriculumDetail = curriculumDetail;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "SubjectInfo{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectTypeId=" + subjectTypeId +
                ", subjectTypeName='" + subjectTypeName + '\'' +
                ", analysis='" + analysis + '\'' +
                ", knowledgeId=" + knowledgeId +
                ", knowledgeName='" + knowledgeName + '\'' +
                ", chapterId=" + chapterId +
                ", chapterName='" + chapterName + '\'' +
                ", curriculumSystemId=" + curriculumSystemId +
                ", curriculumSystemName='" + curriculumSystemName + '\'' +
                ", curriculumSystemDetail='" + curriculumSystemDetail + '\'' +
                ", stageId=" + stageId +
                ", stageName='" + stageName + '\'' +
                ", stageDetail='" + stageDetail + '\'' +
                ", classHour=" + classHour +
                ", curriculumId=" + curriculumId +
                ", curriculumName='" + curriculumName + '\'' +
                ", curriculumDetail='" + curriculumDetail + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
