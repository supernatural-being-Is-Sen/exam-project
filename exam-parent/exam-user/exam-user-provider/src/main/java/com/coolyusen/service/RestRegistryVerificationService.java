package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.user.RegistryVerificationMapper;
import com.coolyusen.exam.pojo.user.RegistryVerification;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/26
 */
@RestController
public class RestRegistryVerificationService {

    @Resource
    private RegistryVerificationMapper registryVerificationMapper;

    @RequestMapping(value = "addRegistryVerification",method = RequestMethod.POST)
    public int addRegistryVerification(@RequestBody RegistryVerification registryVerification){
        return this.registryVerificationMapper.insert(registryVerification);
    }

    /**
     * 依据用户编号查询是否有没有通过的注册信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "findRegistryVerificationByUserIdAndNotPass",method = RequestMethod.POST)
    public RegistryVerification findRegistryVerificationByUserIdAndNotPass(@RequestParam("userId") Long userId){
        return this.registryVerificationMapper.selectOne(
                new QueryWrapper<RegistryVerification>()
                .eq("user_id",userId)
                .eq("whether_to_pass", Constants.DoesItExist.NOT_DELETE)
        );
    }
}
