package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.department.DepartmentMapper;
import com.coolyusen.exam.pojo.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/24
 */
@RestController
public class RestDepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 根据部门编号查询部门
     * @param departmentId
     * @return
     */
    @RequestMapping(value = "findDepartmentById",method = RequestMethod.POST)
    public Department findDepartmentById(@RequestParam("departmentId") Integer departmentId){
        return this.departmentMapper.selectOne(
                new QueryWrapper<Department>().eq("id",departmentId)
        );
    }
}
