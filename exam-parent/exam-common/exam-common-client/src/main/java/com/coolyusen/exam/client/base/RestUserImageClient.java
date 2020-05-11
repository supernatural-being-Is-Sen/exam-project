package com.coolyusen.exam.client.base;

import com.coolyusen.exam.fallback.base.UserImageClientFallback;
import com.coolyusen.exam.pojo.base.UserImage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@FeignClient(value = "exam-base-provider",fallback = UserImageClientFallback.class)
public interface RestUserImageClient {

    @RequestMapping(value = "findUserImageByUserIdAndImageType",method = RequestMethod.POST)
    UserImage findUserImageByUserIdAndImageType(@RequestParam("userId") Long userId,
                                                @RequestParam("imageType") Integer imageType);
}
