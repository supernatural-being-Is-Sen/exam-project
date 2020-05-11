package com.coolyusen.exam.fallback.user;

import com.coolyusen.exam.client.user.RestRegistryVerificationClient;
import com.coolyusen.exam.pojo.user.RegistryVerification;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/26
 */
@Component
public class RegistryVerificationClientFallback implements RestRegistryVerificationClient {


    @Override
    public int addRegistryVerification(RegistryVerification registryVerification) {
        return 0;
    }

    @Override
    public RegistryVerification findRegistryVerificationByUserIdAndNotPass(Long userId) {
        return null;
    }
}
