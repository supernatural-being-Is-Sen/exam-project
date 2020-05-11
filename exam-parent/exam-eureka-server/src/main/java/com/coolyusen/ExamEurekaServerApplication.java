package com.coolyusen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 吴雨森
 */
@EnableEurekaServer
@SpringBootApplication
public class ExamEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamEurekaServerApplication.class, args);
    }
}