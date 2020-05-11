package com.coolyusen.service;

import com.coolyusen.exam.pojo.test.TestType;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
public interface TestTypeService {

    /**
     * 查找所有测试类型
     * @return
     */
    List<TestType> findTestType();
}
