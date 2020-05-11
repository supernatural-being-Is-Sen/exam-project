package com.coolyusen.service.impl;

import com.coolyusen.exam.client.base.RestUserImageClient;
import com.coolyusen.exam.client.curriculum.RestCurriculumSystemClient;
import com.coolyusen.exam.client.curriculum.RestStageClient;
import com.coolyusen.exam.client.department.RestDepartmentClient;
import com.coolyusen.exam.client.department.RestTeacherPositionClient;
import com.coolyusen.exam.client.grade.RestGradeClient;
import com.coolyusen.exam.client.grade.RestStudentOrderGradeClient;
import com.coolyusen.exam.client.user.RestStudentClient;
import com.coolyusen.exam.client.user.RestStudentTypeClient;
import com.coolyusen.exam.client.user.RestTeacherClient;
import com.coolyusen.exam.client.user.RestUsersClient;
import com.coolyusen.exam.common.RedisUtils;
import com.coolyusen.exam.pojo.base.UserImage;
import com.coolyusen.exam.pojo.curriculum.CurriculumSystem;
import com.coolyusen.exam.pojo.curriculum.Stage;
import com.coolyusen.exam.pojo.department.Department;
import com.coolyusen.exam.pojo.department.TeacherPosition;
import com.coolyusen.exam.pojo.grade.Grade;
import com.coolyusen.exam.pojo.grade.StudentOrderGrade;
import com.coolyusen.exam.pojo.user.Student;
import com.coolyusen.exam.pojo.user.StudentType;
import com.coolyusen.exam.pojo.user.Teacher;
import com.coolyusen.exam.pojo.user.Users;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import com.coolyusen.exam.utils.Encryption;
import com.coolyusen.exam.utils.RandomUtil;
import com.coolyusen.exam.vo.StudentInfoVo;
import com.coolyusen.exam.vo.StudentRegistryVo;
import com.coolyusen.exam.vo.TeacherInfoVo;
import com.coolyusen.exam.vo.StudentVerificationVo;
import com.coolyusen.service.UsersService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@Service
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${spring.rabbitmq.verificationCode-queue}",
                        autoDelete = "true"),
                exchange = @Exchange(value = "${spring.rabbitmq.verificationCode-exchange}",
                type = ExchangeTypes.DIRECT),
                key = "${spring.rabbitmq.verificationCode-key}"
        )
)
public class UsersServiceImpl implements UsersService {

    @Autowired
    private RestUsersClient restUsersClient;

    @Autowired
    private RestStudentClient restStudentClient;

    @Autowired
    private RestTeacherClient restTeacherClient;

    @Autowired
    private RestStudentTypeClient restStudentTypeClient;

    @Autowired
    private RestUserImageClient restUserImageClient;

    @Autowired
    private RestTeacherPositionClient restTeacherPositionClient;

    @Autowired
    private RestDepartmentClient restDepartmentClient;

    @Autowired
    private RestStudentOrderGradeClient restStudentOrderGradeClient;

    @Autowired
    private RestGradeClient restGradeClient;

    @Autowired
    private RestCurriculumSystemClient restCurriculumSystemClient;

    @Autowired
    private RestStageClient restStageClient;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Users findUserByEmailAndPassword(Users users) {
        users.setPassword(Encryption.getSha512(users.getPassword()));
        return this.restUsersClient.findUserByEmailAndPassword(users);
    }

    /**
     * 给予用户即可登录
     * @param users 用户信息
     * @return
     */
    @Override
    public Object login(Users users) {
        //判断身份
        if(users.getRole().equals(Constants.UserRole.STUDENT_ROLE)){
            //学生身份
            Student student = this.restStudentClient.findStudentByUserId(users.getId());
            StudentInfoVo studentInfoVo = new StudentInfoVo();
            BeanUtils.copyProperties(users,studentInfoVo);
            studentInfoVo.setUserId(users.getId());
            studentInfoVo.setStuId(student.getId());
            studentInfoVo.setStuNum(student.getStuNum());
            //查找出学生的类型
            StudentType studentType =
                    this.restStudentTypeClient.findStudentTypeByStudentId(student.getStudentTypeId());
            studentInfoVo.setTypeName(studentType.getTypeName());
            //查找出学生的图片
            UserImage userImage = this.findUserImage(
                    users.getId(), Constants.UserImageType.USER_IMAGE);
            studentInfoVo.setImgUrl(userImage.getImgUrl());
            //查找出学生所在的班级
            StudentOrderGrade studentOrderGrade =
                    this.restStudentOrderGradeClient.findStudentOrderGradeByStudentId(student.getId());
            Grade grade =
                    this.restGradeClient.findGradeById(studentOrderGrade.getGradeId());
            studentInfoVo.setGradeId(grade.getId());
            studentInfoVo.setGradeName(grade.getGradeName());
            studentInfoVo.setBeginTime(grade.getBeginTime());
            studentInfoVo.setEndTime(grade.getEndTime());
            //查找出学生所在的阶段和课程体系
            Stage gradeStage =
                    this.restStageClient.findStageById(grade.getStageId());
            studentInfoVo.setStageId(gradeStage.getId());
            studentInfoVo.setStageName(gradeStage.getStageName());
            CurriculumSystem gradeCurriculumSystem =
                    this.restCurriculumSystemClient.findCurriculumSystemById(gradeStage.getCurriculumSystemId());
            studentInfoVo.setCurriculumSystemId(gradeCurriculumSystem.getId());
            studentInfoVo.setCurriculumName(gradeCurriculumSystem.getCurriculumSystemName());
            return studentInfoVo;
        }else if (!users.getRole().equals(Constants.UserRole.STUDENT_ROLE) &&
                ! users.getRole().equals(Constants.UserRole.ADMIN_ROLE)){
            //教师身份
            Teacher teacher = this.restTeacherClient.findTeacherByUserId(users.getId());
            TeacherInfoVo teacherInfoVo = new TeacherInfoVo();
            BeanUtils.copyProperties(users,teacherInfoVo);
            teacherInfoVo.setUserId(users.getId());
            teacherInfoVo.setTeacherId(teacher.getId());
            teacherInfoVo.setTeacherNum(teacher.getTeacherNum());
            //查找出教师的图片
            UserImage teacherImage = this.findUserImage(
                    users.getId(), Constants.UserImageType.USER_IMAGE);
            teacherInfoVo.setImgUrl(teacherImage.getImgUrl());
            //查找出教师的职位
            TeacherPosition teacherPosition =
                    this.restTeacherPositionClient.findTeacherPositionById(teacher.getTeacherPositionId());
            teacherInfoVo.setPositionName(teacherPosition.getPositionName());
            //查找出教师的部门
            Department department =
                    this.restDepartmentClient.findDepartmentById(teacherPosition.getDepartmentId());
            teacherInfoVo.setDepartmentName(department.getDepartmentName());
            return teacherInfoVo;
        }else if (users.getRole().equals(Constants.UserRole.ADMIN_ROLE)){
            //管理员身份
            return users;
        }
        return null;
    }

    @Override
    public String updatePasswordByEmail(String email, String newPassword) {
        return this.restUsersClient.updatePasswordByEmail(email,newPassword);
    }

    @Override
    public StudentRegistryVo sendRegistryStudentRequest(StudentVerificationVo userGradeVo) {
        //密码加密
        userGradeVo.setPassword(Encryption.getSha512(userGradeVo.getPassword()));
        //设置学生默认昵称
        userGradeVo.setNickName(Constants.Users.DEFAULT_STUDENT_NICK_NAME);
        //发送添加学生请求
        long[] userInfo = this.restUsersClient.sendRegistryStudentRequest(userGradeVo);
        if (userInfo[0] < 1) {
            throw new NullPointerException("Failed to send user registration request");
        }
        Grade grade = this.restGradeClient.findGradeById(userGradeVo.getGradeId());
        if(EmptyUtils.isEmpty(grade)){
            throw new NullPointerException("Failed to send class registration request");
        }
        //添加学生
        Student student = new Student();
        student.setStuNum(Constants.Authentication.registryGrade(grade.getGradeName()));
        student.setUserId(userInfo[1]);
        student.setStudentTypeId(Constants.StudentType.NORMAL_STUDENT);
        long[] studentInfo = this.restStudentClient.addStudent(student);
        //判断是否添加成功
        if(studentInfo[0] < 1) {
            throw new NullPointerException("Failed to send student registration request");
        }
        //添加学生班级记录
        StudentOrderGrade studentOrderGrade = new StudentOrderGrade();
        studentOrderGrade.setStuId(studentInfo[1]);
        //设置为不存在
        studentOrderGrade.setStudentOrderGradeDel(Constants.DoesItExist.DELETE_BOOLEAN);
        studentOrderGrade.setGradeId(userGradeVo.getGradeId());
        this.restStudentOrderGradeClient.addStudentOrderGrade(studentOrderGrade);
        //注入学生registryVo
        StudentRegistryVo registryVo = new StudentRegistryVo();
        registryVo.setGradeId(grade.getId());
        registryVo.setStuId(studentInfo[1]);
        BeanUtils.copyProperties(userGradeVo , registryVo);
        registryVo.setUserId(userInfo[1]);
        return registryVo;
    }

    @Override
    public Boolean findUserByEmail(String email) {
        Users user = this.restUsersClient.findUserByEmail(email);
        if(EmptyUtils.isEmpty(user)){
            return null;
        }
        if(user.getUserStatus().equals(Constants.UserStatus.NORMAL) ||
            user.getUserStatus().equals(Constants.UserStatus.FROZEN)){
            return Constants.UserStatusBoolean.NORMAL;
        }else if (user.getUserStatus().equals(Constants.UserStatus.AUTHENTICATION)){
            return Constants.UserStatusBoolean.AUTHENTICATION;
        }
        return null;
    }


    @Override
    public String[] sendVerificationCode(String email) {
        String[] verificationCodeInfo = new String[3];
        verificationCodeInfo[0] = email;
        verificationCodeInfo[1] = RandomUtil.random(6);
        this.restUsersClient.sendVerificationCode(verificationCodeInfo);
        return verificationCodeInfo;
    }

    @Override
    public void makeUserBaseInfo(Users user) {
        this.restUsersClient.makeUserBaseInfoByEmail(user);
    }

    @Override
    public Users findUserInfoByEmail(String email) {
        return this.restUsersClient.findUserByEmail(email);
    }


    @RabbitHandler
    void sendVerificationCodeRabbit(String[] emailVerificationCode) throws MessagingException {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("sen1214166598@163.com");
        String verificationCode = emailVerificationCode[1];
        helper.setSubject("coolyusen exam");
        helper.setText("尊敬的"+emailVerificationCode[0]+"您好,您收到一条邮箱,其验证码为<span style='color:red;font-weight:bolder;'>:"+verificationCode+"</span>",true);
        helper.setTo(emailVerificationCode[0]);
        this.javaMailSender.send(mimeMessage);
        //将验证码加入到redis中
        this.redisUtils.set(Constants.Users.DEFAULT_VERIFICATION_CODE_SUFFIX +
                emailVerificationCode[0],Constants.Redis_Expire.REPLACEMENT_DELAY,verificationCode);
    }

    /**
     * 找到用户图像
     * @param userId
     * @param imageType
     * @return
     */
    private UserImage findUserImage(Long userId,Integer imageType){
        return this.restUserImageClient.findUserImageByUserIdAndImageType(userId,imageType);
    }
}
