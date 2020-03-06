package com.cloud.dy.version;

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
public class CloudDyVersionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDyVersionApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

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

    @RequestMapping("/getVersion")
    public String getVersion() {
        return version;
    }
}
