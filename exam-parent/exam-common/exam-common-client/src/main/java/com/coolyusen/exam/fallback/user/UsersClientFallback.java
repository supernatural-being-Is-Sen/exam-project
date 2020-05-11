package com.coolyusen.exam.fallback.user;

import com.coolyusen.exam.client.user.RestUsersClient;
import com.coolyusen.exam.pojo.user.Users;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@Component
public class UsersClientFallback implements RestUsersClient {

    @Override
    public Users findUserByEmail(String email) {
        return null;
    }

    @Override
    public Users findUserByEmailAndPassword(Users users) {
        return null;
    }

    @Override
    public String generateEmailVerificationCodeToken() {
        return null;
    }

    @Override
    public String updatePasswordByEmail(String email, String newPassword) {
        return null;
    }

    @Override
    public long[] sendRegistryStudentRequest(Users users) {
        return new long[0];
    }

    @Override
    public void sendVerificationCode(String[] emailVerificationCode) {

    }

    @Override
    public void makeUserBaseInfoByEmail(Users user) {

    }

    @Override
    public List<Users> findUsersByIds(List<Long> usersIds) {
        return null;
    }
}
