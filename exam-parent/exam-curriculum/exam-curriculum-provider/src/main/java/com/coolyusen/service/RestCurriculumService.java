package com.coolyusen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coolyusen.exam.mapper.curriculum.CurriculumMapper;
import com.coolyusen.exam.pojo.curriculum.Curriculum;
import com.coolyusen.exam.utils.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@RestController
public class RestCurriculumService {

    @Resource
    private CurriculumMapper curriculumMapper;

    /**
     * 根据课程编号查询课程
     * @param curriculumIdList 课程集合编号
     * @return 课程集合
     */
    @RequestMapping(value = "findCurriculumById",method = RequestMethod.POST)
    public List<Curriculum> findCurriculumByIdList(@RequestBody List<Integer> curriculumIdList){
        return this.curriculumMapper.selectList(
                new QueryWrapper<Curriculum>()
                .in("id",curriculumIdList)
                .eq("curriculum_del", Constants.DoesItExist.NOT_DELETE)
        );
    }
}
