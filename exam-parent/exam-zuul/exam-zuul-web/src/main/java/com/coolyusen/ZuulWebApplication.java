package com.coolyusen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 吴雨森
 * @data 2020/2/25
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableRedisHttpSession
public class ZuulWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulWebApplication.class,args);
    }
}
