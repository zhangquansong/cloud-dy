package com.cloud.dy.gateway.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.dy.gateway.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author pc
 * @title: TestServiceImpl
 * @projectName cloud-dy
 * @date 2020/3/1520:49
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {


    @SentinelResource(value = "doSomething")
    @Override
    public void doSomething(String s) {
        log.info("doSomething : {}", s);
        System.out.println("doSomething------------" + s);
    }
}
