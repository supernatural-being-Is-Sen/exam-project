package com.coolyusen.controller;

import com.coolyusen.exam.common.Dto;
import com.coolyusen.exam.common.DtoUtil;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.service.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@RestController
@RequestMapping("testType")
public class TestTypeController {

    @Autowired
    private TestTypeService testTypeService;

    /**
     * 返回所有测试类型
     * @return
     */
    @RequestMapping(value = "findTestType",method = RequestMethod.GET)
    public Dto findTestType(){
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,
                this.testTypeService.findTestType());
    }
}
