package com.cloud.dy.version.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.dy.user.entity.User;

import java.util.List;

/**
 * @Author zhangquansong
 * @Date 21:23 2020/3/7
 * @Description :     用户基本操作CURD接口
 * @return
 **/
public interface UserService extends IService<User> {

    /**
     * @param
     * @return java.util.List<com.cloud.dream.serveruser.dao.entity.User>
     * @Author zhangquansong
     * @Date 2019/3/19 0019 下午 4:21
     * @Description :查询所有用户列表
     **/
    List<User> listAll();

    void saveUser() throws Exception;

    /**
     * @param user
     * @return void
     * @Author zhangquansong
     * @Description : 新增用户
     * @Date 17:27 2019/7/13
     **/
    void saveUser(User user);


    /**
     * @param user
     * @return void
     * @Author zhangquansong
     * @Description :修改用户
     * @Date 17:16 2019/7/13
     **/
    void updateUser(User user);

    /**
     * @param id
     * @return void
     * @Author zhangquansong
     * @Description : 删除用户信息
     * @Date 17:18 2019/7/13
     **/
    void deleteUser(Long id);

    /**
     * @param id
     * @return com.cloud.dream.user.entity.User
     * @Author zhangquansong
     * @Description : 根据id查询用户信息
     * @Date 17:19 2019/7/13
     **/
    User findById(Long id);
}