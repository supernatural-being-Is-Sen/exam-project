package com.coolyusen.exam.fallback.test;

import com.coolyusen.exam.client.test.RestUserTestClient;
import com.coolyusen.exam.pojo.test.UserTest;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@Component
public class UserTestClientFallback implements RestUserTestClient {
    @Override
    public long addUserTest(UserTest userTest) {
        return 0;
    }

    @Override
    public UserTest findUserTestById(Long userTestId) {
        return null;
    }

    @Override
    public void updateUserTestInfo(UserTest userTest) {

    }
}
