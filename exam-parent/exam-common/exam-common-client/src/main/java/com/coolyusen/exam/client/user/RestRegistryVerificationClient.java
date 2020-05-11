package com.coolyusen.exam.client.user;

import com.coolyusen.exam.fallback.user.RegistryVerificationClientFallback;
import com.coolyusen.exam.pojo.user.RegistryVerification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/26
 */
@FeignClient(name = "exam-users-provider",fallback = RegistryVerificationClientFallback.class)
public interface RestRegistryVerificationClient {

    /**
     * 添加一条认证记录
     * @param registryVerification
     * @return
     */
    @RequestMapping(value = "addRegistryVerification",method = RequestMethod.POST)
    int addRegistryVerification(@RequestBody RegistryVerification registryVerification);

    /**
     * 依据用户编号查询是否有没有通过的注册信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "findRegistryVerificationByUserIdAndNotPass",method = RequestMethod.POST)
    RegistryVerification findRegistryVerificationByUserIdAndNotPass(@RequestParam("userId") Long userId);
}
