package com.coolyusen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 吴雨森
 */

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ExamConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamConfigServerApplication.class, args);
    }

}
