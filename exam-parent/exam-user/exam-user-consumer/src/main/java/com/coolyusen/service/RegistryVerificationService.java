package com.coolyusen.service;

import com.coolyusen.exam.pojo.user.RegistryVerification;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
public interface RegistryVerificationService {

    int addRegistryVerification(RegistryVerification registryVerification);

    /**
     * 依据用户编号查询是否有没有通过的注册信息
     * @param userId
     * @return
     */
    RegistryVerification findRegistryVerificationByUserIdAndNotPass(Long userId);
}
