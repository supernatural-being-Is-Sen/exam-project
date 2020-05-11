package com.coolyusen.controller;

import com.coolyusen.exam.common.Dto;
import com.coolyusen.exam.common.DtoUtil;
import com.coolyusen.exam.pojo.grade.Grade;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@RestController
@RequestMapping("grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "findGradeAll",method = RequestMethod.GET)
    public Dto<Grade> findGradeAll(){
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,this.gradeService.findGradeAll());
    }
}
