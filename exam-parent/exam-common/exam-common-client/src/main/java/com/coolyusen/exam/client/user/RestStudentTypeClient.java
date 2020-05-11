package com.coolyusen.exam.client.user;

import com.coolyusen.exam.fallback.user.StudentTypeClientFallback;
import com.coolyusen.exam.pojo.user.StudentType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@FeignClient(name = "exam-users-provider",fallback = StudentTypeClientFallback.class)
public interface RestStudentTypeClient {

    /**
     * 依照学生编号查询学生的类型
     * @param studentId 学生编号
     * @return  学生类型
     */
    @RequestMapping(value = "findStudentTypeByStudentId",method = RequestMethod.POST)
    StudentType findStudentTypeByStudentId(@RequestParam("studentId") Integer studentId);
}
