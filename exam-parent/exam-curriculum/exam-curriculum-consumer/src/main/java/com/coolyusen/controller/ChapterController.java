package com.coolyusen.controller;

import com.coolyusen.exam.common.Dto;
import com.coolyusen.exam.common.DtoUtil;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.exam.utils.EmptyUtils;
import com.coolyusen.exam.vo.StudentInfoVo;
import com.coolyusen.service.ChapterService;
import com.coolyusen.service.CurriculumStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 吴雨森
 * @data 2019/11/29
 */
@RestController
@RequestMapping("curriculum")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private CurriculumStageService curriculumStageService;

    /**
     * 依照阶段查找课程以及对应的章节
     * @return
     */
    @RequestMapping(value = "stu/findCurriculumChapterByStageId",method = RequestMethod.POST)
    public Dto findCurriculumChapterByStageId(HttpSession session){
        StudentInfoVo userInfo = (StudentInfoVo) session.getAttribute(Constants.SpringSessionRedis.SPRING_SESSION_USER);
        if(EmptyUtils.isEmpty(userInfo)){
            return DtoUtil.returnFail("您好,请重新登录",Constants.CommonCode.USER_NO_LOGIN);
        }
        //所有的课程和章节
        Object curriculumChapterVoList =
                 this.chapterService.findCurriculumChapterByStageId(userInfo.getStageId());
        //判断是否为空
        if(EmptyUtils.isEmpty(curriculumChapterVoList)){
            return DtoUtil.returnFail("没有找到此阶段对应的课程和章节", Constants.CommonCode.SUCCESS);
        }else if (curriculumChapterVoList.equals(Constants.CurriculumStatus.CURRICULUM_NOT_FOUNT)){
            //此阶段没有找到课程
            return DtoUtil.returnFail(Constants.CurriculumStatus.CURRICULUM_NOT_FOUNT,
                    Constants.CommonCode.SUCCESS);
        }
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,curriculumChapterVoList);
    }


    /**
     * 查询课程阶段信息
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "findCurriculumStageInfo",method = RequestMethod.POST)
    public Dto findCurriculumStageInfo(@RequestParam(required = false) Map<String,String> searchMap){

        /*this.curriculumStageService.findCurriculumStageInfo(
                searchMap.get("curriculumSystemId"),
                searchMap.get("curriculumId"),
                searchMap.get("stageId"),
                searchMap.get("groupFlag") == null ? false : true
        )*/
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,
                this.curriculumStageService.findCurriculumStageInfo(
                        searchMap.get("curriculumSystemId") == "" ? null:Integer.parseInt(searchMap.get("curriculumSystemId")),
                        searchMap.get("curriculumId") == "" ? null :Integer.parseInt(searchMap.get("curriculumId")),
                        searchMap.get("stageId") == "" ? null : Integer.parseInt(searchMap.get("stageId")),
                        searchMap.get("groupFlag") == "" ? false : true
                ));
    }

    /**
     * 根据课程编号查找对应的章节
     * @param curriculumId
     * @return
     */
    @RequestMapping("getChapterByCurriculum")
    public Dto getChapterByCurriculum(@RequestParam Integer curriculumId){
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,
                this.chapterService.getChapterByCurriculum(curriculumId));
    }
}