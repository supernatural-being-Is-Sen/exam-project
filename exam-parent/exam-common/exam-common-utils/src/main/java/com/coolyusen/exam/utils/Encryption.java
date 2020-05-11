package com.coolyusen.exam.utils;

import com.google.common.hash.Hashing;

/**
 * 各种加密
 * @author 吴雨森
 * @data 2019/11/23
 */
public class Encryption {


    /**
     * MD5加密
     */
    public static String getMd5(String plainText){
        return Hashing.md5().hashBytes(plainText.getBytes()).toString();
    }

    /**
     * sha1 加密
     */
    public static String getSha1(String plainText){
        return Hashing.sha1().hashBytes(plainText.getBytes()).toString();
    }

    /**
     * sha256加密
     */
    public static String getSha256(String plainText){
        return Hashing.sha256().hashBytes(plainText.getBytes()).toString();
    }

    /**
     * sha512加密
     */
    public static String getSha512(String plainText){
        return Hashing.sha512().hashBytes(plainText.getBytes()).toString();
    }



}
