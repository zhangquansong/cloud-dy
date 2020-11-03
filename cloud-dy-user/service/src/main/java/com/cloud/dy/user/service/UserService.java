package com.cloud.dy.user.service;

import com.cloud.dy.user.entity.User;

import java.util.List;

/**
 * @author zhangquansong
 * @title: UserService
 * @projectName cloud-dy
 * @description:
 * @date 2020/8/7下午1:38
 */
public interface UserService {

    Integer saveUser(User user);

    List<User> list();
}