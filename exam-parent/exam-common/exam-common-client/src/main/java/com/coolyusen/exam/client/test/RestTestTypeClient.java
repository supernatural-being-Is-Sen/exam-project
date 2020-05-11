package com.coolyusen.exam.client.test;

import com.coolyusen.exam.fallback.test.TestTypeClientFallback;
import com.coolyusen.exam.pojo.test.TestType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@FeignClient(name = "exam-test-provider",fallback = TestTypeClientFallback.class)
public interface RestTestTypeClient {

    /**
     * 查找所有测试类型
     * @return
     */
    @RequestMapping(value = "findTestType",method = RequestMethod.GET)
    List<TestType> findTestType();

    /**
     * 依照测试类型编号查找测试类型
     * @param testTypeId 测试类型编号
     * @return 测试类型
     */
    @RequestMapping(value = "findTestTypeById",method = RequestMethod.POST)
    TestType findTestTypeById(@RequestParam("testTypeId") Integer testTypeId);
}
