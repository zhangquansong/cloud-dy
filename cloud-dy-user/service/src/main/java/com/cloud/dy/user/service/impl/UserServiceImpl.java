package com.cloud.dy.user.service.impl;

import com.cloud.dy.user.entity.User;
import com.cloud.dy.user.mapper.UserMapper;
import com.cloud.dy.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhangquansong
 * @Date 21:24 2020/3/7
 * @Description :   用户基本CURD操作实现类
 * @return
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @param user
     * @return java.lang.Integer
     * @throws
     * @description:
     * @author zhangquansong
     * @date 2020/8/7 下午2:04
     */
    @Override
    public Integer saveUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> list() {
        return userMapper.selectList(null);
    }
}