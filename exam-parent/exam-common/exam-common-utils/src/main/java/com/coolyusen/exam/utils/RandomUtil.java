package com.coolyusen.exam.utils;

import java.util.Random;

/**
 * @author 吴雨森
 * @data 2019/12/11
 */
public class RandomUtil {


    private static Random random = new Random();

    /**
     * 根据位数发送随机数量的验证码
     * @param size
     * @return
     */
    public static String random(int size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
