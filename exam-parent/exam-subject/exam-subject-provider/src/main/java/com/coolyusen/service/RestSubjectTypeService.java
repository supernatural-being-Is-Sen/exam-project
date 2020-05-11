package com.coolyusen.service;

import com.coolyusen.exam.mapper.subject.SubjectTypeMapper;
import com.coolyusen.exam.pojo.subject.SubjectType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/30
 */
@RestController
public class RestSubjectTypeService {

    @Resource
    private SubjectTypeMapper subjectTypeMapper;


    /**
     * 找到所有的题目类型
     * @return
     */
    @RequestMapping(value = "findSubjectType",method = RequestMethod.GET)
    public List<SubjectType> findSubjectType(){
        return this.subjectTypeMapper.selectList(null);
    }
}
