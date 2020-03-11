package com.cloud.dy.common.redis;

import com.cloud.dy.common.result.UserLoginVO;
import com.cloud.dy.common.utils.Constants;
import com.cloud.dy.common.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : RedisExtendUtils
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:18
 * @Description : redis业务工具类
 **/
@Component
public class RedisExtendUtils {

    /**
     * 默认24小时后过期
     */
    @Value("${token.expire: 18000}")
    private int expire;

    @Autowired
    RedisUtils redisUtils;

    /**
     * 登录token操作
     *
     * @param user 用户信息
     */
    @Async
    public void setLoginToken(UserLoginVO user, String token) {
        Map<String, Object> getToken = redisUtils.hmgetToken(String.valueOf(user.getUserId()));
        if (null != getToken && StringUtils.isNotBlank((String) getToken.get(Constants.KEY_NAME_TOKEN))) { // 删除用户上次登录的token
            redisUtils.deleteToken((String) getToken.get(Constants.KEY_NAME_TOKEN));
            redisUtils.deleteToken(String.valueOf(user.getUserId()));
        }
        Map<String, Object> map = new HashMap<>(Constants.INTEGER_VALUE_1);
        map.put(Constants.KEY_NAME_TOKEN, token);
        redisUtils.hmsetToken(String.valueOf(user.getUserId()), map);
        user.setExpireTime(DateUtils.addDay(new Date(), Constants.INTEGER_VALUE_1));
        redisUtils.setToken(token, user);
    }

    /**
     * @param userId 用户id
     * @return void
     * @Author zhangquansong
     * @Date 2019/1/5 0005 下午 6:22
     * @Description :   删除用户token
     **/
    @Async
    public void loginOutToken(Long userId) {
        Map<String, Object> getToken = redisUtils.hmgetToken(String.valueOf(userId));
        if (null != getToken && StringUtils.isNotBlank((String) getToken.get(Constants.KEY_NAME_TOKEN))) { // 删除用户上次登录的token
            redisUtils.deleteToken((String) getToken.get(Constants.KEY_NAME_TOKEN));
            redisUtils.deleteToken(String.valueOf(userId));
        }
    }
}