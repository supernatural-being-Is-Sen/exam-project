package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.grade.GradeMapper;
import com.coolyusen.exam.pojo.grade.Grade;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@RestController
public class RestGradeService {

    @Resource
    private GradeMapper gradeMapper;

    /**
     * 依据班级编号查找班级
     * @param gradeId
     * @return
     */
    @RequestMapping(value = "findGradeById",method = RequestMethod.POST)
    public Grade findGradeById(@RequestParam("gradeId") Long gradeId){
        return this.gradeMapper.selectOne(new QueryWrapper<Grade>()
        .eq("id",gradeId));
    }

    /**
     * 查找所有班级
     * @return
     */
    @RequestMapping(value = "findGradeAll",method = RequestMethod.POST)
    public List<Grade> findGradeAll(){
        return this.gradeMapper.selectList(new QueryWrapper<Grade>()
        .eq("grade_del", Constants.DoesItExist.NOT_DELETE));
    }

    /**
     * 根据班级编号找到班级编号数组查找班信息
     * @param gradeIds
     * @return
     */
    @RequestMapping(value = "findGradeByIds",method = RequestMethod.POST)
    public List<Grade> findGradeByIds(@RequestBody List<Long> gradeIds){
        return this.gradeMapper.selectList(
            new QueryWrapper<Grade>()
                .in("id",gradeIds)
                .eq("grade_del",Constants.DoesItExist.NOT_DELETE)
        );
    }
}
