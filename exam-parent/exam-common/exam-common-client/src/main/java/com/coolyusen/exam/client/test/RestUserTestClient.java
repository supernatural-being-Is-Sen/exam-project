package com.coolyusen.exam.client.test;

import com.coolyusen.exam.fallback.test.UserTestClientFallback;
import com.coolyusen.exam.pojo.test.UserTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@FeignClient(name = "exam-test-provider",fallback = UserTestClientFallback.class)
public interface RestUserTestClient {

    /**
     * 添加一条用户测试
     * @param userTest
     * @return
     */
    @RequestMapping(value = "addUserTest",method = RequestMethod.POST)
    long addUserTest(@RequestBody UserTest userTest);

    /**
     * 根据测试编号查找本次测试
     * @param userTestId
     * @return
     */
    @RequestMapping(value = "findUserTestById",method = RequestMethod.POST)
    UserTest findUserTestById(@RequestParam("userTestId") Long userTestId);


    /**
     * 修改用户测试信息
     * @param userTest
     */
    @RequestMapping(value = "updateUserAnswer",method = RequestMethod.POST)
    void updateUserTestInfo(@RequestBody UserTest userTest);
}
