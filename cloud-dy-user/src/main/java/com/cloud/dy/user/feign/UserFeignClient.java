package com.cloud.dy.user.feign;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.entity.User;
import com.cloud.dy.user.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName UserFeignClient
 * @Description TODO
 * @Auther zhangquansong
 * @Date 2020/3/31 19:51
 * @Version 1.0
 **/
@FeignClient(name = "cloud-dy-version", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {


    @RequestMapping(value = "/version/getUser", method = RequestMethod.GET)
    R<User> getUser();
}
