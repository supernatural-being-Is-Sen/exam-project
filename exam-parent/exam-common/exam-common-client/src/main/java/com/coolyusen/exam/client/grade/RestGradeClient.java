package com.coolyusen.exam.client.grade;

import com.coolyusen.exam.fallback.grade.GradeClientFallback;
import com.coolyusen.exam.pojo.grade.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@FeignClient(value = "exam-grade-provider",fallback = GradeClientFallback.class)
public interface RestGradeClient {

    /**
     * 依据班级编号查找班级
     * @param gradeId
     * @return
     */
    @RequestMapping(value = "findGradeById",method = RequestMethod.POST)
    Grade findGradeById(@RequestParam("gradeId") Long gradeId);


    /**
     * 查找所有班级
     * @return
     */
    @RequestMapping(value = "findGradeAll",method = RequestMethod.POST)
    List<Grade> findGradeAll();

    /**
     * 根据班级编号找到班级编号数组查找班信息
     * @param gradeIds
     * @return
     */
    @RequestMapping(value = "findGradeByIds",method = RequestMethod.POST)
    List<Grade> findGradeByIds(@RequestBody List<Long> gradeIds);
}
