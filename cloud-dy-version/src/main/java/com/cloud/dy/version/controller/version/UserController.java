package com.cloud.dy.version.controller.version;

import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.clouddyapi.param.GetVersionParam;
import com.cloud.dy.common.utils.CheckUtil;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.service.UserService;
import com.cloud.dy.version.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author zhangquansong
 * @Description : 用户控制层
 * @Date 9:50 2020/3/11
 **/
@Slf4j
@RestController
@RequestMapping("/version")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @param
     * @Author zhangquansong
     * @Description : 查询所有用户列表
     * @Date 9:51 2020/3/11
     **/
    @GetMapping("/queryList")
    @ResponseBody
    public R<List<User>> listAll() {
//        User user = restTemplate.getForObject("http://cloud-dy-version:8783/getUser", User.class);
        log.info("user is :{}", JSONObject.toJSONString("xxxx"));
        return R.successResponse(userService.listAll());
    }

    @GetMapping("/getUser")
    @ResponseBody
    public R<User> getUser() throws Exception {
//        userService.saveUser();
        List<User> users = userService.listAll();
        if (CheckUtil.isEmpty(users)) {
            return null;
        }
        log.info("user is :{}", JSONObject.toJSONString(users));
        return R.successResponse(users.get(0));
    }

    /*@PostMapping("/getVersion")
    @ResponseBody
    public R<User> getVersion(@RequestBody GetVersionParam getVersionParam) throws Exception {
        log.info("getVersionParam : {}", JSONObject.toJSONString(getVersionParam));
        List<User> users = userService.listAll();
        if (CheckUtil.isEmpty(users)) {
            return null;
        }
        log.info("user is :{}", JSONObject.toJSONString(users));
        return R.successResponse(users.get(0));
    }*/
}