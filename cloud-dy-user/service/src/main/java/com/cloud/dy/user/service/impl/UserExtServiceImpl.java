package com.cloud.dy.user.service.impl;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.entity.User;
import com.cloud.dy.user.feign.VersionFeignClient;
import com.cloud.dy.user.service.UserExtService;
import com.cloud.dy.user.service.UserService;
import com.cloud.dy.versionapi.param.SaveVersionParam;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "cloud-dy-user")
    @ShardingTransactionType(TransactionType.BASE)
    public R saveUser(SaveVersionParam saveVersionParam) {
        log.info("---> start save user <---");
        java.util.Random rd = new java.util.Random();
        User user = new User();
        user.setUserLoginName("11");
        user.setUserName(rd.nextInt(99999) + 10 + "");
        user.setUserFace(UUID.randomUUID().toString().replaceAll("-", ""));
        int sj = rd.nextInt(2) + 1;//因为是从0开始的，排除0就+1
        user.setUserSex(sj);
        userService.saveUser(user);
        saveVersionParam.setVersion(user.getId() + "");
        versionFeignClient.saveVersion(saveVersionParam);
//        Integer i = 1 / 0;
        return R.successResponse();
    }

}