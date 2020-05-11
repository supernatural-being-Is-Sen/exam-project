package com.coolyusen.service.impl;

import com.coolyusen.exam.client.grade.RestGradeClient;
import com.coolyusen.exam.pojo.grade.Grade;
import com.coolyusen.service.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Resource
    private RestGradeClient restGradeClient;

    @Override
    public List<Grade> findGradeAll() {
        return this.restGradeClient.findGradeAll();
    }
}
