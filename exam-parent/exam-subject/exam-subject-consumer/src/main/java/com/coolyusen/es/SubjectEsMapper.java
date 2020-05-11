package com.coolyusen.es;

import com.coolyusen.pojo.SubjectInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 吴雨森
 * @data 2020/2/5
 */
public interface SubjectEsMapper extends ElasticsearchRepository<SubjectInfo,Long> {
}
