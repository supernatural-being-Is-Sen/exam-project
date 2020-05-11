package com.coolyusen.exam.fallback.base;

import com.coolyusen.exam.client.base.RestUserImageClient;
import com.coolyusen.exam.pojo.base.UserImage;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@Component
public class UserImageClientFallback implements RestUserImageClient {

    @Override
    public UserImage findUserImageByUserIdAndImageType(Long userId, Integer imageType) {
        return null;
    }
}
