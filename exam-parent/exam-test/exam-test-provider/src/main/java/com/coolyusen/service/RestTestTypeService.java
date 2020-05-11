package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.test.TestTypeMapper;
import com.coolyusen.exam.pojo.test.TestType;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@RestController
public class RestTestTypeService {

    @Resource
    private TestTypeMapper testTypeMapper;

    /**
     * 查找所有存在的测试类型
     * @return
     */
    @RequestMapping(value = "findTestType",method = RequestMethod.GET)
    public List<TestType> findTestType(){
        return this.testTypeMapper.selectList(
                new QueryWrapper<TestType>()
                .eq("test_type_del", Constants.DoesItExist.NOT_DELETE)
        );
    }

    /**
     * 依照测试类型编号查找测试类型
     * @param testTypeId 测试类型编号
     * @return 测试类型
     */
    @RequestMapping(value = "findTestTypeById",method = RequestMethod.POST)
    public TestType findTestTypeById(@RequestParam("testTypeId") Integer testTypeId){
        return this.testTypeMapper.selectOne(
                new QueryWrapper<TestType>()
                .eq("id",testTypeId)
        );
    }
}
