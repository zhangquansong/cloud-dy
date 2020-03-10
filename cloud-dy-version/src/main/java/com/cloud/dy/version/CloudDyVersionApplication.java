package com.cloud.dy.version;

import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.version.entity.User;
import com.cloud.dy.version.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
@EnableFeignClients
@MapperScan(basePackages = {"com.cloud.dy.version.mapper"})
@Slf4j
public class CloudDyVersionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDyVersionApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private UserService userService;

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
    public String getVersion() throws Exception {
        log.info("version is : {}", version);
        userService.saveUser();
        List<User> users = userService.listAll();
        return JSONObject.toJSONString(users);
    }
}
