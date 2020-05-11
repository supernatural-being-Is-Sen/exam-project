package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.curriculum.CurriculumSystemMapper;
import com.coolyusen.exam.pojo.curriculum.CurriculumSystem;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 吴雨森
 * @data 2019/11/25
 */
@RestController
public class RestCurriculumSystemService {

    @Resource
    private CurriculumSystemMapper curriculumSystemMapper;

    /**
     * 根据课程体系编号查找课程体系
     * @param curriculumSystemId
     * @return
     */
    @RequestMapping(value = "findCurriculumSystemById",method = RequestMethod.POST)
    public CurriculumSystem findCurriculumSystemById(@RequestParam("curriculumSystemId") Integer curriculumSystemId){
        return this.curriculumSystemMapper.selectOne(
                new QueryWrapper<CurriculumSystem>()
                .eq("id",curriculumSystemId)
                .eq("curriculum_system_del", Constants.DoesItExist.NOT_DELETE)
        );
    }


}
