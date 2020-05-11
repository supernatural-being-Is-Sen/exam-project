package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.exam.ExamTypeMapper;
import com.coolyusen.exam.pojo.exam.ExamType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/12/7
 */
@RestController
public class RestExamTypeService {

    @Resource
    private ExamTypeMapper examTypeMapper;

    /**
     * 查找所有的考试类型
     * @return 所有的考试类型
     */
    @RequestMapping(value = "findExamType",method = RequestMethod.GET)
    public List<ExamType> findExamType(){
        return this.examTypeMapper.selectList(null);
    }

    /**
     * 根据考试类型编号查找考试类型
     * @param examTypeId
     * @return
     */
    @RequestMapping(value = "findExamTypeById",method = RequestMethod.POST)
    public ExamType findExamTypeById(@RequestParam("examTypeId") Integer examTypeId){
        return this.examTypeMapper.selectOne(
                new QueryWrapper<ExamType>()
                .eq("id",examTypeId)
        );
    }
}
