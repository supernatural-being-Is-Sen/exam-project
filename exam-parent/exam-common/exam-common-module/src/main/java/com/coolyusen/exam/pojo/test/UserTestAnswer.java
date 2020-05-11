package com.coolyusen.exam.pojo.test;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴雨森
 * @since 2019-11-23
 */
public class UserTestAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 测试编号
     */
    private Long testSubjectId;

    /**
     * 用户答案
     */
    private Object answer;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestSubjectId() {
        return testSubjectId;
    }

    public void setTestSubjectId(Long testSubjectId) {
        this.testSubjectId = testSubjectId;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserTestAnswer{" +
        "id=" + id +
        ", testSubjectId=" + testSubjectId +
        ", answer=" + answer +
        "}";
    }
}
