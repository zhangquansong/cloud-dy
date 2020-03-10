package com.cloud.dy.version.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.dy.version.entity.User;
import com.cloud.dy.version.mapper.UserMapper;
import com.cloud.dy.version.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhangquansong
 * @Date 21:24 2020/3/7
 * @Description :   用户基本CURD操作实现类
 * @return
 **/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * @param
     * @return java.util.List<com.cloud.dream.serveruser.dao.entity.User>
     * @Author zhangquansong
     * @Date 2019/3/19 0019 下午 4:21
     * @Description :查询所有用户列表
     **/
    @Override
    public List<User> listAll() {
        return this.list(null);
    }

    @Override
//    @GlobalTransactional
    @Transactional
    public void saveUser() throws Exception {
        User user = new User();
        user.setUserLoginName("11");
        user.setUserName("22");
        java.util.Random rd = new java.util.Random();
        int sj = rd.nextInt(2) + 1;//因为是从0开始的，排除0就+1
        user.setUserSex(sj);
        this.save(user);
    }

    /**
     * @param user
     * @return void
     * @Author zhangquansong
     * @Description : 新增用户
     * @Date 17:27 2019/7/13
     **/
    @Override
    public void saveUser(User user) {
        this.save(user);
    }

    /**
     * @param user
     * @return void
     * @Author zhangquansong
     * @Description :修改用户
     * @Date 17:16 2019/7/13
     **/
    @Override
    public void updateUser(User user) {
        this.updateById(user);
    }

    /**
     * @param id
     * @return void
     * @Author zhangquansong
     * @Description : 删除用户信息
     * @Date 17:18 2019/7/13
     **/
    @Override
    public void deleteUser(Long id) {
        this.removeById(id);
    }

    /**
     * @param id
     * @return com.cloud.dream.user.entity.User
     * @Author zhangquansong
     * @Description : 根据id查询用户信息
     * @Date 17:19 2019/7/13
     **/
    @Override
    public User findById(Long id) {
        return this.findById(id);
    }


}