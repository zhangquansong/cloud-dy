package com.cloud.dy.gateway;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

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

    @GetMapping("/api")
    @SentinelResource("api")
    public Set<ApiDefinition> apiRules() {
        return GatewayApiDefinitionManager.getApiDefinitions();
    }

    @GetMapping("/gateway")
    @SentinelResource("gateway")
    public Set<GatewayFlowRule> apiGateway() {
        return GatewayRuleManager.getRules();
    }

    @GetMapping("/flow")
    @SentinelResource("flow")
    public List<FlowRule> apiFlow() {
        return FlowRuleManager.getRules();
    }
}
