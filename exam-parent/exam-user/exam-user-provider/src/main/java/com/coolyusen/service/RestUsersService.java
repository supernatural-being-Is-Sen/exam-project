package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.user.UsersMapper;
import com.coolyusen.exam.pojo.user.Users;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.Encryption;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 吴雨森
 * @data 2019/11/23 18:44
 */
@RestController
public class RestUsersService {

    private String tokenPrefix = "token";

    @Resource
    private UsersMapper usersMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发送验证码交换机名称
    @Value("${spring.rabbitmq.verificationCode-exchange}")
    private String verificationCodeExchange;

    //发送验证码的路由键
    @Value("${spring.rabbitmq.verificationCode-key}")
    private String verificationCodeKey;

    @RequestMapping(value = "findUserByEmail",method = RequestMethod.POST)
    public Users findUserByEmail(@RequestParam("email") String email){
        return this.usersMapper.selectOne(new QueryWrapper<Users>()
        .eq("email",email));
    }

    @RequestMapping(value = "findUserByEmailAndPassword",method = RequestMethod.POST)
    public Users findUserByEmailAndPassword(@RequestBody Users users){
        return this.usersMapper.selectOne(new QueryWrapper<Users>()
        .eq("email",users.getEmail()).eq("password",users.getPassword())
        .eq("user_del",Constants.DoesItExist.NOT_DELETE));
    }

    /**
     * 生成邮箱验证码token
     * @return
     */
    @RequestMapping(value = "generateEmailVerificationCodeToken",method = RequestMethod.GET)
    public String generateEmailVerificationCodeToken(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.tokenPrefix+"-");
        sb.append("PC-");
        sb.append("email-");
        sb.append(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+"-");
        sb.append(UUID.randomUUID().toString().substring(0,6));
        return sb.toString();
    }

    /**
     * 修改密码
     * @return 新密码
     */
    @RequestMapping(value = "updatePasswordByEmail",method = RequestMethod.POST)
    public String updatePasswordByEmail(@RequestParam("email") String email,
                                        @RequestParam("newPassword") String newPassword){
        if(this.usersMapper.updatePasswordByEmail(email,Encryption.getSha512(newPassword)) > 0){
            return newPassword;
        }
        return null;
    }

    /**
     * 添加一个用户并返回用的添加数量和用户的id
     * @param users 用户
     * @return
     */
    @RequestMapping(value = "sendRegistryStudentRequest",method = RequestMethod.POST)
    public long[] sendRegistryStudentRequest(@RequestBody Users users){
        return new long[]{this.usersMapper.addUser(users),users.getId()};
    }

    /**
     * 发送邮箱验证码
     * @param emailVerificationCode
     */
    @RequestMapping(value = "sendVerificationCode",method = RequestMethod.POST)
    public void sendVerificationCode(@RequestParam("emailVerificationCode") String[] emailVerificationCode){
        //发送发送邮箱验证码
        this.rabbitTemplate.convertAndSend(this.verificationCodeExchange,
                                            this.verificationCodeKey,emailVerificationCode);
    }

    /**
     * 根据用户邮箱修改用户的基本信息
     * @param user 用户
     */
    @RequestMapping(value = "makeUserBaseInfoByEmail",method = RequestMethod.POST)
    public void makeUserBaseInfoByEmail(@RequestBody Users user){
        this.usersMapper.makeUserBaseInfoByEmail(user);
    }

    /**
     * 根据用户编号list找到用户信息
     * @param usersIds
     * @return
     */
    @RequestMapping(value = "findUsersByIds",method = RequestMethod.POST)
    public List<Users> findUsersByIds(@RequestParam("userIds") List<Long> usersIds){
        if(usersIds.isEmpty()) {
            return null;
        }
        return this.usersMapper.selectList(
                new QueryWrapper<Users>()
                .in("id",usersIds)
                .eq("user_del",Constants.DoesItExist.NOT_DELETE)
        );
    }
}
