package com.cloud.dy.user;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Slf4j
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
@EnableFeignClients
@MapperScan(basePackages = {"com.cloud.dy.user.mapper"})
public class CloudDyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDyUserApplication.class, args);
    }

    @Bean
//    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/helloSentinel")
    @SentinelResource("helloSentinel")
    public String helloSentinel() {
        return "Hello Sentinel" + UUID.randomUUID();
    }

}
