package com.coolyusen.exam.client.department;

import com.coolyusen.exam.fallback.department.TeacherPositionClientFallback;
import com.coolyusen.exam.pojo.department.TeacherPosition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@FeignClient(name = "exam-department-provider",fallback = TeacherPositionClientFallback.class)
public interface RestTeacherPositionClient {

    @RequestMapping(value = "findTeacherPositionById",method = RequestMethod.POST)
    TeacherPosition findTeacherPositionById(@RequestParam("teacherPositionId") Integer teacherPositionId);
}
