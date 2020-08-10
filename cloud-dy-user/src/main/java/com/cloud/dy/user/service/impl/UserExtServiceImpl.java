package com.cloud.dy.user.service.impl;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.entity.User;
import com.cloud.dy.user.feign.VersionFeignClient;
import com.cloud.dy.user.service.UserExtService;
import com.cloud.dy.user.service.UserService;
import com.cloud.dy.versionapi.param.SaveVersionParam;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhangquansong
 * @Date 21:24 2020/3/7
 * @Description :   用户基本CURD操作实现类
 * @return
 **/
@Slf4j
@Service
public class UserExtServiceImpl implements UserExtService {

    @Autowired
    private UserService userService;
    @Autowired
    private VersionFeignClient versionFeignClient;

    @GlobalTransactional
    @Override
    public R saveUser(SaveVersionParam saveVersionParam) {
        User user = new User();
        user.setUserLoginName("11");
        user.setUserName("22");
        userService.saveUser(user);
        versionFeignClient.saveVersion(saveVersionParam);
        Integer i = 1 / 0;
        return R.successResponse();
    }

}