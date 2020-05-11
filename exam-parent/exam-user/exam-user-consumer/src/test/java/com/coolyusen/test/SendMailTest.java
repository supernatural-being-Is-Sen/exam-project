package com.coolyusen.test;

import com.coolyusen.exam.utils.EmptyUtils;
import com.coolyusen.exam.utils.RandomUtil;
import com.coolyusen.exam.vo.StudentInfoVo;
import com.coolyusen.exam.vo.TeacherInfoVo;
import com.coolyusen.exam.vo.UsersVo;
import com.coolyusen.service.UsersService;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailTest {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JavaMailSender javaMailSender;

    Random random = new Random();

    @Test
    public void send() throws MessagingException {
        StringBuilder ran = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            ran.append(random.nextInt(10));
        }
        System.out.println(ran);
    }

    @Test
    public void sendEmail() throws MessagingException {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String email = "1214166598@qq.com";
        helper.setFrom("sen1214166598@163.com");
        String verificationCode = RandomUtil.random(6);
        helper.setSubject("coolyusen exam");
        helper.setText("尊敬的"+email+"您好,您收到一条邮箱,其验证码为<span style='color:red;font-weight:bolder;'>:"+verificationCode+"</span>",true);
        helper.setTo(email);
        this.javaMailSender.send(mimeMessage);
    }

    @Test
    public void a(){
        UsersVo usersVo = new TeacherInfoVo();
        if(usersVo instanceof  StudentInfoVo){
            System.out.println("studentInfo");
        }else if (usersVo instanceof TeacherInfoVo){
            System.out.println("teacherInfoVo");
        }
    }
}