package com.coolyusen;

import com.coolyusen.exam.pojo.user.Users;
import com.coolyusen.exam.utils.ListUtil;
import com.coolyusen.service.ExamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestS {

    @Test
    public void test1(){
       /* Users users = new Users();
        users.setId(1L);
        List<Users> list = ListUtil.newArrayList();
        list.add(users);*/
        System.out.println("1".equals(1));
    }

}
