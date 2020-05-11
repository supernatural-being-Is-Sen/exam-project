package com.coolyusen.service.impl;

import com.coolyusen.exam.client.user.RestRegistryVerificationClient;
import com.coolyusen.exam.pojo.user.RegistryVerification;
import com.coolyusen.service.RegistryVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 吴雨森
 * @data 2019/11/26
 */
@Service
public class RegistryVerificationServiceImpl implements RegistryVerificationService {

    @Autowired
    private RestRegistryVerificationClient restRegistryVerificationClient;

    @Override
    public int addRegistryVerification(RegistryVerification registryVerification) {
        return this.restRegistryVerificationClient.addRegistryVerification(registryVerification);
    }


    @Override
    public RegistryVerification findRegistryVerificationByUserIdAndNotPass(Long userId) {
        return this.restRegistryVerificationClient.findRegistryVerificationByUserIdAndNotPass(userId);
    }
}
