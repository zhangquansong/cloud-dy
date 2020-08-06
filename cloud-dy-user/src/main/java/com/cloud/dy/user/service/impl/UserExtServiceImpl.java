package com.cloud.dy.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.dy.common.utils.CheckUtil;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.entity.User;
import com.cloud.dy.user.feign.VersionFeignClient;
import com.cloud.dy.user.mapper.UserMapper;
import com.cloud.dy.user.param.LoginParam;
import com.cloud.dy.user.service.UserExtService;
import com.cloud.dy.user.service.UserService;
import com.cloud.dy.user.vo.LoginVO;
import com.cloud.dy.versionapi.param.SaveVersionParam;
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
public class UserExtServiceImpl extends ServiceImpl<UserMapper, User> implements UserExtService {


    @Autowired
    private UserService userService;

    @Autowired
    private VersionFeignClient versionFeignClient;

    /**
     * @return com.cloud.dy.user.entity.User
     * @Author zhangquansong
     * @Description : 根据用户名密码查询用户信息
     * @Date 15:29 2020/5/16
     **/
    @Override
    public R<LoginVO> login(LoginParam param) {
        User user = userService.queryByPhone(param.getPhone());
        if (CheckUtil.isEmpty(user)) {
            return R.errorResponse(100000, "手机号不存在");
        }
        if (!param.getPassword().equals(user.getUserPassword())) {
            return R.errorResponse(100001, "密码不正确");
        }
        /*user = userService.queryByPhoneAndPassword(param.getPhone(), param.getPassword());
        if (CheckUtil.isEmpty(user)) {
            return R.errorResponse(100002, "用户不存在");
        }*/
        return R.successResponse();
    }

    //    @GlobalTransactional
    @Override
    public R<Boolean> saveVersion(SaveVersionParam saveVersionParam) {
        User user = new User();
        user.setUserLoginName("11");
        user.setUserName("22");
        java.util.Random rd = new java.util.Random();
        int sj = rd.nextInt(2) + 1;//因为是从0开始的，排除0就+1
        user.setUserSex(sj);
        userService.saveUser(user);
        R<Boolean> booleanR = versionFeignClient.saveVersion(saveVersionParam);
//        int i = 1 / 0;
        return R.successResponse();
    }
}