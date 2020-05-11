package com.coolyusen.exam.utils;

/**
 * 常量类
 *
 * @author 吴雨森
 * @data 2019/11/23
 */
public class Constants {


    /**
     * 用户权限
     */
    public static class UserRole {
        //管理员权限
        public static final Integer ADMIN_ROLE = 0;
        //学生权限
        public static final Integer STUDENT_ROLE = 1;
        //教员
        public static final Integer TEACHER_ROLE = 2;
        //班主任
        public static final Integer Headmaster_ROLE = 3;
        //教务
        public static final Integer EDUCATIONAL_ADMINISTRATION_ROLE = 4;
    }

    /**
     * 用户图片类型
     */
    public static class UserImageType {
        //用户头像
        public static final Integer USER_IMAGE = 0;
        //微信头像
        public static final Integer WX_IMAGE = 1;
    }

    /**
     * 考试信息
     */
    public static class ExamInfo{
        public static final String EXAM_BASE_INFO = "exam_base_info：";
    }

    /**
     * 是否存在
     */
    public static class DoesItExist {
        //存在
        public static final Integer NOT_DELETE = 0;
        //不存在
        public static final Integer DELETE = 1;
        //存在
        public static final Boolean DELETE_BOOLEAN = true;
        //不存在
        public static final Boolean NOT_DELETE_BOOLEAN = false;
    }

    /**
     * 空返回值
     */
    public static class NullValue {
        //空值
        public static final String EMPTY = "empty";
    }

    //通用状态码 00**
    public static class CommonCode {
        //登录成功
        public static final String SUCCESS = "0000";
        //用户未登录
        public static final String USER_NO_LOGIN = "0001";
        //登录失败
        public static final String EXCEPTION = "0002";
        //其它
        public static final String OTHER = "0003";
    }

    /**
     * 用户状态
     */
    public static class UserStatus {
        //认证中
        public static final Integer AUTHENTICATION = 0;
        //正常
        public static final Integer NORMAL = 1;
        //停封
        public static final Integer FROZEN = 2;
    }

    /**
     * 身份真类型
     */
    public static class IdCardType {
        //身份证
        public static final Integer ID_CARD = 1;
        //护照
        public static final Integer PASSPORT = 2;
    }

    /**
     * redis缓存失效时长
     */
    public static class Redis_Expire {
        public static final long DEFAULT_EXPIRE = 60;//80s 有慢sql，超时时间设置长一点
        public final static int SESSION_TIMEOUT = 2 * 60 * 60;//默认2h
        public final static int REPLACEABLE_TIME_RANGE = 32 * 60;
        public final static int REPLACEMENT_PROTECTION_TIMEOUT = SESSION_TIMEOUT - REPLACEABLE_TIME_RANGE;//默认1.5h
        public final static int REPLACEMENT_DELAY = 2 * 60;//默认2min
    }

    /**
     * spring session redis 名称
     */
    public static class SpringSessionRedis{
        //用户Spring Session 名称
        public static final String SPRING_SESSION_USER = "userInfo";
    }

    /**
     * 学生认证请求
     */
    public static class Authentication{
        //
        public static String registryGrade(String gradeName){
            return gradeName+":Authentication";
        }
    }

    /**
     * 学生类型
     */
    public static class StudentType{
        //班长
        public static final Integer MONITOR = 1;
        //学习委员
        public static final Integer LEARNING_COMMISSARY = 2;
        //普通学员
        public static final Integer NORMAL_STUDENT = 3;
    }

    /**
     * true || false 类型用户状态
     */
    public static class UserStatusBoolean{
        public static final boolean NORMAL = true;
        public static final boolean AUTHENTICATION = false;
    }

    /**
     * 用户
     */
    public static class Users{
        //默认学生昵称
        public static final String DEFAULT_STUDENT_NICK_NAME = "cool student";
        //默认邮箱验证码前缀
        public static final String DEFAULT_VERIFICATION_CODE_SUFFIX = "verification-code:";
        //邮箱token
        public static final String EMAIL_TOKEN = "email-token";
    }

    /**
     * 用户图片
     */
    public static class UserImage{
        //用户默认头像
        public static final String DEFAULT_USER_IMAGE = "http://q1gzvufz3.bkt.clouddn.com/logo.png";
    }

    /**
     * curriculum 未找到
     */
    public static class CurriculumStatus{
        //课程未找到
        public static final String CURRICULUM_NOT_FOUNT = "curriculum not fount";
    }

    /**
     * 题目模块
     */
    public static class SubjectStatus{
        //知识点未找到
        public static final String KNOWLEDGE_NOT_FOUNT = "knowledge not fount";
        //题目未找到
        public static final String SUBJECT_NOT_FOUND = "subject not fount";
    }


    /**
     * 测试类型
     */
    public static class TestType{
        //专项技能型
        public static final Integer SPECIAL_SKILL_TYPE = 1;
    }

    /**
     * 题目类型
     */
    public static class SubjectType{
        //单选题
        public static final Integer SINGLE_CHOICE_QUESTION = 1;
        //多选题
        public static final Integer MULTPLE_CHOICE_QUESTION = 2;
    }

    /**
     * 题目信息
     */
    public static class SubjectInfo{

        public static final String SUBJECT_INFO = "subject:";

        public static final String SUBJECT_BASE_INFO = "subject-base:";
    }

    /**
     * 考试类型
     */
    public static class ExamType{
        //模拟考试
        public static final Integer MOCKEXAM = 1;
    }

    public static class Page{
        //默认每页显示数量
        public static final int DEFAULT_PAGE = 10;
    }
}
