package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.base.UserImageMapper;
import com.coolyusen.exam.pojo.base.UserImage;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@RestController
public class RestUserImageService {

    @Resource
    private UserImageMapper userImageMapper;

    @RequestMapping(value = "findUserImageByUserIdAndImageType",method = RequestMethod.POST)
    public UserImage findUserImageByUserIdAndImageType(@RequestParam("userId") Integer userId,
                                                       @RequestParam("imageType") Integer imageType){
        return this.userImageMapper.selectOne(
                new QueryWrapper<UserImage>().eq("user_id",userId)
                .eq("image_type",imageType)
                .eq("img_del", Constants.DoesItExist.NOT_DELETE)
        );
    }
}