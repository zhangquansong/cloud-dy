package com.cloud.dy.user.service;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.versionapi.param.SaveVersionParam;

/**
 * @author zhangquansong
 * @title: UserService
 * @projectName cloud-dy
 * @description:
 * @date 2020/8/7下午1:38
 */
public interface UserExtService {

    R saveUser(SaveVersionParam saveVersionParam);
}
