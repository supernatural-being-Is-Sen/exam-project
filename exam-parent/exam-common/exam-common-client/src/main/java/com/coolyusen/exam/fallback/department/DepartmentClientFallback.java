package com.coolyusen.exam.fallback.department;

import com.coolyusen.exam.client.department.RestDepartmentClient;
import com.coolyusen.exam.pojo.department.Department;
import org.springframework.stereotype.Component;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@Component
public class DepartmentClientFallback implements RestDepartmentClient {

    @Override
    public Department findDepartmentById(Integer departmentId) {
        return null;
    }
}
