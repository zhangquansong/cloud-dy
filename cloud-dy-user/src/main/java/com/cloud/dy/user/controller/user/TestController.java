package com.cloud.dy.user.controller.user;

import com.cloud.dy.user.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author zhangquansong
 * @Description :
 * @Date 10:33 2020/3/11
 **/
@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/hello")
    public String hello() {
        testService.doSomething("hello" + new Date());
        return "aceleeyy.com";
    }

}