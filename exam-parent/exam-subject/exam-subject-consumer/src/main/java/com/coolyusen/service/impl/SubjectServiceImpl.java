package com.coolyusen.service.impl;

import com.alibaba.fastjson.JSON;
import com.coolyusen.es.SubjectEsMapper;
import com.coolyusen.exam.client.curriculum.RestChapterClient;
import com.coolyusen.exam.client.curriculum.RestCurriculumStageClient;
import com.coolyusen.exam.client.subject.RestAnswerClient;
import com.coolyusen.exam.client.subject.RestKnowledgeClient;
import com.coolyusen.exam.client.subject.RestSubjectClient;
import com.coolyusen.exam.client.subject.RestSubjectTypeClient;
import com.coolyusen.exam.pojo.curriculum.Chapter;
import com.coolyusen.exam.pojo.subject.Answer;
import com.coolyusen.exam.pojo.subject.Knowledge;
import com.coolyusen.exam.pojo.subject.Subject;
import com.coolyusen.exam.pojo.subject.SubjectType;
import com.coolyusen.exam.utils.EmptyUtils;
import com.coolyusen.exam.utils.ListUtil;
import com.coolyusen.exam.utils.SubjectUtil;
import com.coolyusen.exam.vo.CurriculumStageInfoVo;
import com.coolyusen.exam.vo.SubjectVo;
import com.coolyusen.pojo.SubjectInfo;
import com.coolyusen.service.SubjectService;
import com.google.common.collect.ImmutableMap;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 吴雨森
 * @data 2020/2/7
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectEsMapper subjectEsMapper;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private RestSubjectTypeClient restSubjectTypeClient;

    @Autowired
    private RestSubjectClient restSubjectClient;

    @Autowired
    private RestAnswerClient restAnswerClient;

    @Autowired
    private RestKnowledgeClient restKnowledgeClient;

    @Autowired
    private RestChapterClient restChapterClient;

    @Autowired
    private RestCurriculumStageClient restCurriculumStageClient;

    @Autowired
    private SubjectUtil subjectUtil;

    @Override
    public void addSubjectInfoToElasticsearch() {
        List<SubjectVo> subjectVos = ListUtil.newArrayList();
        //题目id
        List<Long> subjectId = ListUtil.newArrayList();
        //查找所有题目类型
        List<SubjectType> subjectType =
                this.restSubjectTypeClient.findSubjectType();
        //根据题目的id找到题目
        List<Subject> subjects =
                this.restSubjectClient.findSubjectByIdList(subjectId);
        List<Long> subjectIdList = ListUtil.newArrayList();
        //添加题目的基本信息
        this.subjectUtil.addSubjects(subjectVos,subjects,subjectType,subjectIdList);
        List<Answer> answerList =
                this.restAnswerClient.findAnswerBySubjectList(subjectIdList);
        //添加题目答案
        this.subjectUtil.addAnswerBySubjectIdList(answerList,subjectVos);
        List<SubjectInfo> subjectInfos = ListUtil.newArrayList();
        subjectVos.forEach(
                subjectVo -> {
                    SubjectInfo subjectInfo = new SubjectInfo();
                    BeanUtils.copyProperties(subjectVo,subjectInfo);
                    subjectInfos.add(subjectInfo);
                }
        );
        //所有章节
        List<Chapter> chapters = this.restChapterClient.findAllChapter();
        //所有知识点
        List<Knowledge> knowledges = this.restKnowledgeClient.findAllKnowledge();
        chapters.forEach(
                chapter -> {
                    knowledges.forEach(
                            knowledge -> {
                                subjectInfos.forEach(
                                        subjectInfo -> {
                                            if(subjectInfo.getKnowledgeId().equals(knowledge.getId()) && knowledge.getChapterId().equals(chapter.getId())){
                                                subjectInfo.setKnowledgeName(knowledge.getKnowledgeName());
                                                subjectInfo.setChapterId(chapter.getId());
                                                subjectInfo.setChapterName(chapter.getChapterName());
                                                subjectInfo.setCurriculumId(chapter.getCurriculumId());
                                            }
                                        }
                                );
                            }
                    );
                }
        );
        //查询出所有的阶段信息
        List<CurriculumStageInfoVo> curriculumStageInfos =
                this.restCurriculumStageClient.findCurriculumStageInfo(null,null,null,false);
        curriculumStageInfos.forEach(
                curriculumStageInfoVo -> {
                    subjectInfos.forEach(
                            subjectInfo -> {
                                if(subjectInfo.getCurriculumId().equals(curriculumStageInfoVo.getCurriculumId())){
                                    BeanUtils.copyProperties(curriculumStageInfoVo,subjectInfo);
                                }
                            }
                    );
                }
        );
        this.subjectEsMapper.saveAll(subjectInfos);
    }

    @Override
    public Map<String, Object> selectSubjectInfo(Map<String, String> searchMap) {
        NativeSearchQueryBuilder builder = this.searchCondition(searchMap);
        Map<String, Object> resultMap = this.searchList(builder);
        return resultMap;
    }

    @Override
    public List<Subject> findRandomSubjectsByChapter(Integer chapterId, Integer number,Integer[] notSelect) {
        return restSubjectClient.findRandomSubjectByChapter(chapterId,number,notSelect);
    }

    /**
     * 进行条件查询
     *
     * @param searchMap
     * @return
     */
    public NativeSearchQueryBuilder searchCondition(Map<String, String> searchMap) {
        //搜索条件构建对象，用于封装各种搜索条件
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        //多条加查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (!searchMap.isEmpty()) {
            String subjectName = searchMap.get("subjectName");
            if (EmptyUtils.isNotEmpty(subjectName)) {
                boolQueryBuilder.must(QueryBuilders.queryStringQuery(subjectName).field("subjectName"));
            }
            String stageId = searchMap.get("stageId");
            if(EmptyUtils.isNotEmpty(stageId)) {
                boolQueryBuilder.must(QueryBuilders.queryStringQuery(stageId).field("stageId"));
            }
            String chapterId = searchMap.get("chapterId");
            if(EmptyUtils.isNotEmpty(chapterId)) {
                boolQueryBuilder.must(QueryBuilders.queryStringQuery(chapterId).field("chapterId"));
            }
        }
        Integer[] page = convertPage(searchMap);
        builder.withPageable(PageRequest.of(page[0] - 1, page[1]));
        return builder.withQuery(boolQueryBuilder);
    }

    /**
     * 分页页数
     *
     * @param searchMap
     * @return
     */
    private Integer[] convertPage(Map<String, String> searchMap) {
        String pageNum = searchMap.get("pageNum");
        String pageSize = searchMap.get("pageSize");
        if (pageNum == null) {
            pageNum = "1";
        }
        if (pageSize == null) {
            pageSize = "10";
        }
        return new Integer[]{Integer.parseInt(pageNum), Integer.parseInt(pageSize)};
    }


    /**
     * 进行查询搜索
     *
     * @param builder
     * @return
     */
    private Map<String, Object> searchList(NativeSearchQueryBuilder builder) {
        //高亮搜索
        HighlightBuilder.Field field = new HighlightBuilder.Field("subjectName");
        //前缀
        field.preTags("<em style='color:red'>");
        //后缀
        field.postTags("</em>");
        //碎片长度 关键词数据的长度
        field.fragmentSize(100);
        //添加高亮搜索
        builder.withHighlightFields(field);

        // AggregatedPage ： 搜索结果集的封装
        // 参数1 ： 搜素条件封装
        // 参数2 ： 搜索集合要转换类型的字节码
        // 参数3 ： 执行搜索后，将数据结果集封装到该对象中
        AggregatedPage<SubjectInfo> subjectInfos =
                this.elasticsearchTemplate.queryForPage(
                        builder.build(),
                        SubjectInfo.class,
                        new SearchResultMapper() {
                            @Override
                            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                                //执行查询，获取所有数据->结果集【高亮数据 | 非高亮数据】
                                SearchHits hits = searchResponse.getHits();
                                //存储所有转换后的高亮数据对象
                                List<T> list = new ArrayList<>();
                                for (SearchHit hit : hits) {
                                    //分析结果集数据，获取非高亮数据
                                    SubjectInfo subjectInfo = JSON.parseObject(hit.getSourceAsString(), SubjectInfo.class);
                                    //获取高亮数据
                                    HighlightField name = hit.getHighlightFields().get("subjectName");
                                    if (name != null && name.getFragments() != null) {
                                        //读取出高亮数据
                                        Text[] fragments = name.getFragments();
                                        StringBuilder sb = new StringBuilder();
                                        for (Text fragment : fragments) {
                                            sb.append(fragment.toString());
                                        }
                                        //非高亮数据中指定的域替换成高亮数据
                                        subjectInfo.setSubjectName(sb.toString());
                                    }
                                    //将高亮数据添加到集合中
                                    list.add((T) subjectInfo);
                                }
                                /*
                                1) 集合数据
                                2) 分页对象
                                3) 搜索记录总条数
                                        */
                                return new AggregatedPageImpl<T>(
                                        list, pageable, searchResponse.getHits().getTotalHits()
                                );
                            }
                        });
        return ImmutableMap.of("content",subjectInfos.getContent(),
                "pages",subjectInfos.getTotalPages(),"total",subjectInfos.getTotalElements());
    }
}
