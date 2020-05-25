package com.cloud.dy.user.controller.user;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.feign.VersionFeignClient;
import com.cloud.dy.user.param.LoginParam;
import com.cloud.dy.user.service.UserExtService;
import com.cloud.dy.user.service.UserService;
import com.cloud.dy.user.vo.LoginVO;
import com.cloud.dy.versionapi.param.GetVersionParam;
import com.cloud.dy.versionapi.param.SaveVersionParam;
import com.cloud.dy.versionapi.vo.GetVersionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private UserExtService userExtService;
    @Autowired
    private VersionFeignClient getVersionFeignClient;


    @PostMapping("/getVersion")
    @ResponseBody
    public R<GetVersionVO> getVersion(@RequestBody GetVersionParam getVersionParam) {
        log.info("user service getVersionParam :{} ", JSONObject.toJSONString(getVersionParam));
        return getVersionFeignClient.getVersion(getVersionParam);
    }

    @PostMapping("/saveVersion")
    @ResponseBody
    public R<Boolean> saveVersion(@RequestBody SaveVersionParam saveVersionParam) {
        return userExtService.saveVersion(saveVersionParam);
    }


    @PostMapping("/login")
    @SentinelResource("login")
    @ResponseBody
    public R<LoginVO> login(@RequestBody LoginParam param) {
        return userExtService.login(param);
    }

    @GetMapping("/info")
    @SentinelResource("info")
    @ResponseBody
    public R<String> info(@RequestParam("token") String token) {
        return R.successResponse();
    }

}