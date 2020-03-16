package com.cloud.dy.gateway;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
@EnableFeignClients
public class CloudDyGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDyGatewayApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 注解支持的配置Bean
    /*@Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }*/


    @Value("${version}")
    private String version;
    @Value("${cloudDream}")
    private String cloudDream;
    @Value("${capacity}")
    private int capacity;
    @Value("${refillTokens}")
    private int refillTokens;
    @Value("${refillDuration}")
    private int refillDuration;

    @SentinelResource(
            value = "getVersion"
    )
    @RequestMapping("/getVersion")
    public String getVersion() {
        return version;
    }

}
