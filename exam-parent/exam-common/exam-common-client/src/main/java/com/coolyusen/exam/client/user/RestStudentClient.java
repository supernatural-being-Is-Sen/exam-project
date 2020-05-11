package com.coolyusen.exam.client.user;

import com.coolyusen.exam.fallback.user.StudentClientFallback;
import com.coolyusen.exam.pojo.user.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@FeignClient(name = "exam-users-provider",fallback = StudentClientFallback.class)
public interface RestStudentClient {

    /**
     * 依照用户编号查看学生信息
     * @param userId 用户编号
     * @return 学生信息
     */
    @RequestMapping(value = "findStudentByUserId",method = RequestMethod.POST)
    Student findStudentByUserId(@RequestParam("userId") Long userId);

    /**
     * 添加一名学生
     * @param student
     * @return
     */
    @RequestMapping(value = "addStudent",method = RequestMethod.POST)
    long[] addStudent(@RequestBody Student student);
}
