package com.cloud.dy.gateway.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.gateway.entity.User;
import com.cloud.dy.gateway.handler.DiscoveryClientControllerBackHandler;
import com.cloud.dy.gateway.handler.DiscoveryClientControllerFallBackHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhangquansong
 * @Description :
 * @Date 10:33 2020/3/11
 **/
@Slf4j
@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @SentinelResource(
            value = "testgateway"
    )
    @RequestMapping("/testgateway")
    public String getVersion() {
        return "111";
    }

    /**
     * @param
     * @Author zhangquansong
     * @Description : 查询所有用户列表
     * @Date 9:51 2020/3/11
     **/
    @SentinelResource(
            value = "client:fegin:test",
            blockHandler = "defaultMessage",
            fallback = "defaultMessage",
            blockHandlerClass = DiscoveryClientControllerBackHandler.class
//            ,
//            fallbackClass = DiscoveryClientControllerFallBackHandler.class
    )
    @GetMapping("/queryUser")
    @ResponseBody
    public R<User> listAll() {
        User user = restTemplate.getForObject("http://cloud-dy-user:8782/user/queryList", User.class);
        log.info("user is :{}", JSONObject.toJSONString(user));
        return R.successResponse(user);
    }
}