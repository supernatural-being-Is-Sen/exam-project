package com.coolyusen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author 吴雨森
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableElasticsearchRepositories("com.coolyusen.es")
public class ExamSubjectConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamSubjectConsumerApplication.class, args);
    }
}
