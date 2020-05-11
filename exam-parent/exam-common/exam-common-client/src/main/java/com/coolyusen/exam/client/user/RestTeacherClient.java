package com.coolyusen.exam.client.user;

import com.coolyusen.exam.fallback.user.TeacherClientFallback;
import com.coolyusen.exam.pojo.user.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/23
 */
@FeignClient(name = "exam-users-provider",fallback = TeacherClientFallback.class)
public interface RestTeacherClient {

    /**
     * 依照用户编号查询教师
     * @param userId 用户编号
     * @return 教师信息
     */
    @RequestMapping(value = "findTeacherByUserId",method = RequestMethod.POST)
    Teacher findTeacherByUserId(@RequestParam("userId") Long userId);

    /**
     * 根据教师编号集合找到教师信息
     * @param teacherIds
     * @return
     */
    @RequestMapping(value = "findTeacherByTeacherIds",method = RequestMethod.POST)
    List<Teacher> findTeacherByTeacherIds(@RequestParam("teacherIds") List<Long> teacherIds);
}
