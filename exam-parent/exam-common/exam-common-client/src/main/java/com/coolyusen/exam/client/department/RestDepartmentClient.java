package com.coolyusen.exam.client.department;

import com.coolyusen.exam.fallback.department.DepartmentClientFallback;
import com.coolyusen.exam.pojo.department.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@FeignClient(name = "exam-department-provider",fallback = DepartmentClientFallback.class)
public interface RestDepartmentClient {

    @RequestMapping(value = "findDepartmentById",method = RequestMethod.POST)
    Department findDepartmentById(@RequestParam("departmentId") Integer departmentId);
}
