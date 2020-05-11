package com.coolyusen.service.impl;

import com.coolyusen.exam.client.test.RestTestTypeClient;
import com.coolyusen.exam.pojo.test.TestType;
import com.coolyusen.service.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@Service
public class TestTypeServiceImpl implements TestTypeService {

    @Autowired
    private RestTestTypeClient testTypeClient;

    @Override
    public List<TestType> findTestType() {
        return this.testTypeClient.findTestType();
    }
}
