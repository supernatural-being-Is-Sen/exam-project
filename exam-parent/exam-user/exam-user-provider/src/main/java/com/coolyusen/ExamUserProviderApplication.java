package com.coolyusen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 吴雨森
 */

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.coolyusen.exam.mapper.user")
public class ExamUserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamUserProviderApplication.class, args);
    }
}