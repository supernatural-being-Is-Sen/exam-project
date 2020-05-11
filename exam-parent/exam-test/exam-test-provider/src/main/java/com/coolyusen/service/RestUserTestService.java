package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.test.UserTestMapper;
import com.coolyusen.exam.pojo.test.UserTest;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@RestController
public class RestUserTestService {

    @Resource
    private UserTestMapper userTestMapper;

    /**
     * 添加一条用户测试,(返回主键)
     * @param userTest
     * @return
     */
    @RequestMapping(value = "addUserTest",method = RequestMethod.POST)
    public Long addUserTest(@RequestBody UserTest userTest){
        if(EmptyUtils.isEmpty(userTest)){
            return null;
        }
        this.userTestMapper.addUserTest(userTest);
        return userTest.getId();
    }

    /**
     * 根据测试编号查找本次测试
     * @param userTestId
     * @return
     */
    @RequestMapping(value = "findUserTestById",method = RequestMethod.POST)
    public UserTest findUserTestById(@RequestParam("userTestId") Long userTestId){
        return this.userTestMapper.selectOne(
                new QueryWrapper<UserTest>()
                        .eq("id",userTestId)
        );
    }

    /**
     * 修改用户测试信息
     * @param userTest
     */
    @RequestMapping(value = "updateUserAnswer",method = RequestMethod.POST)
    public void updateUserTestInfo(@RequestBody UserTest userTest){
        this.userTestMapper.updateById(userTest);
    }
}
