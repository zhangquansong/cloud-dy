package com.cloud.dy.user.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.entity.User;
import com.cloud.dy.user.fallback.UserFeignClientFallback;
import com.cloud.dy.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author zhangquansong
 * @Description : 用户控制层
 * @Date 9:50 2020/3/11
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserFeignClientFallback userFeignClientFallback;

    /**
     * @param
     * @Author zhangquansong
     * @Description : 查询所有用户列表
     * @Date 9:51 2020/3/11
     **/
    @GetMapping("/queryList")
    @ResponseBody
    public R<List<User>> listAll() {
        R<User> user = restTemplate.getForObject("http://cloud-dy-version:8783/version/getUser", R.class);
        log.info("user is :{}", JSONObject.toJSONString(user));
        return R.successResponse(userService.listAll());
    }

    @GetMapping("/userFeign")
    @ResponseBody
    public R<User> userFeign() {
        R<User> user = userFeignClientFallback.getUser();
        log.info("user is :{}", JSONObject.toJSONString(user));
        return user;
    }


}