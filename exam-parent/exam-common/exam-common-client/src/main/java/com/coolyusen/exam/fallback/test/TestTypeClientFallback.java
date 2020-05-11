package com.coolyusen.exam.fallback.test;

import com.coolyusen.exam.client.test.RestTestTypeClient;
import com.coolyusen.exam.pojo.test.TestType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@Component
public class TestTypeClientFallback implements RestTestTypeClient {
    @Override
    public List<TestType> findTestType() {
        return null;
    }

    @Override
    public TestType findTestTypeById(Integer testTypeId) {
        return null;
    }
}
