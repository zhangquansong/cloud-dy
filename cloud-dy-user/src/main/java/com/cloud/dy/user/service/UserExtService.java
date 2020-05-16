package com.cloud.dy.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.entity.User;
import com.cloud.dy.user.param.LoginParam;
import com.cloud.dy.user.vo.LoginVO;

/**
 * @Author zhangquansong
 * @Date 21:23 2020/3/7
 * @Description :     用户基本操作CURD接口
 * @return
 **/
public interface UserExtService extends IService<User> {
    R<LoginVO> login(LoginParam param);
}