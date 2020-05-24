package com.cloud.dy.user.controller.user;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangquansong
 * @Description : 用户控制层
 * @Date 9:50 2020/3/11
 **/
//@Slf4j
@RestController
//@RequestMapping("/user")
public class TestController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/hellVersion")
//    @SentinelResource("hellVersion")
    @ResponseBody
    public R<String> test() {
        String version = userFeignClient.helloVersion("1.2.3.4");
        return R.successResponse(version);
    }

}