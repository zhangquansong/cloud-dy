package com.cloud.dy.user.controller.user;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.service.UserExtService;
import com.cloud.dy.versionapi.param.SaveVersionParam;
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
    private UserExtService userExtService;


    @PostMapping("/saveVersion")
    @ResponseBody
    public R<Boolean> saveVersion(@RequestBody SaveVersionParam saveVersionParam) {
        return userExtService.saveUser(saveVersionParam);
    }


}