package com.cloud.dy.gateway;

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

import java.util.UUID;

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

    //    @SentinelResource(value = "gatewaySentinel")
    @RequestMapping("/gatewaySentinel")
    public String getVersion() {
        return UUID.randomUUID().toString();
    }

}
