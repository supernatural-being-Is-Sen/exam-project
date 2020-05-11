package com.coolyusen.service.impl;

import com.coolyusen.exam.client.curriculum.RestChapterClient;
import com.coolyusen.exam.client.curriculum.RestCurriculumClient;
import com.coolyusen.exam.client.curriculum.RestCurriculumStageClient;
import com.coolyusen.exam.pojo.curriculum.Chapter;
import com.coolyusen.exam.pojo.curriculum.Curriculum;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import com.coolyusen.exam.vo.CurriculumChapterVo;
import com.coolyusen.service.ChapterService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private RestCurriculumStageClient restCurriculumStageClient;

    @Autowired
    private RestCurriculumClient restCurriculumClient;

    @Autowired
    private RestChapterClient restChapterClient;

    @Override
    public Object findCurriculumChapterByStageId(Integer stageId) {
        //章节对应的课程编号
        List<Integer> curriculumIdList =
                this.restCurriculumStageClient.findCurriculumIdByStageId(stageId);
        if(EmptyUtils.isEmpty(curriculumIdList)){
            return Constants.CurriculumStatus.CURRICULUM_NOT_FOUNT;
        }
        //按照课程编号找到阶段对应的所有课程
        List<Curriculum> curriculumById = this.restCurriculumClient.findCurriculumByIdList(
                curriculumIdList
        );
        //最终的vo返回结果
        List<CurriculumChapterVo> curriculumChapterVoList = Lists.newArrayList();
        //便利所有课程
        for (Curriculum curriculum : curriculumById) {
            //vo对象
            CurriculumChapterVo curriculumChapterVo = new CurriculumChapterVo();
            curriculumChapterVo.setCurriculumName(curriculum.getCurriculumName());
            curriculumChapterVo.setChapterList(
                    this.restChapterClient.findChapterListByCurriculumId(curriculum.getId()));
            curriculumChapterVoList.add(curriculumChapterVo);
        }
        return curriculumChapterVoList;
    }

    @Override
    public List<Chapter> getChapterByCurriculum(Integer curriculum) {
        return this.restChapterClient.findChapterListByCurriculumId(curriculum);
    }
}
