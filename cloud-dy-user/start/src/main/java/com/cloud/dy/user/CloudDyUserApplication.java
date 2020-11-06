package com.cloud.dy.user;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = "com.cloud.dy.user")
@RestController
@EnableDiscoveryClient
@RefreshScope
@EnableFeignClients
//@MapperScan(basePackages = {"com.cloud.dy.user"})
@MapperScan("com.cloud.dy.user.mapper")
public class CloudDyUserApplication {

    @Value("${server.port}")
    private String serverPort;
    @Value("${my.tenantId.tableFilter.list}")
    private String tableFilter;

    public static void main(String[] args) {
        // 重点，调用ElasticApmAttacher.attach();函数
//        ElasticApmAttacher.attach();
        SpringApplication.run(CloudDyUserApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/userSentinel")
    @SentinelResource("userSentinel")
    public String userSentinel() {
        log.info("====tableFilter:{}", tableFilter);
        log.info("====info###port:{}", serverPort);
        log.warn("====warn###port:{}", serverPort);
        log.error("====error###port:{}", serverPort);
        return "Hello User Sentinel" + UUID.randomUUID();
    }

}
