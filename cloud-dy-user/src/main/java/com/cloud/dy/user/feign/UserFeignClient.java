package com.cloud.dy.user.feign;

import com.cloud.dy.clients.version.VersionFegin;
import com.cloud.dy.user.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ClassName UserFeignClient
 * @Description TODO
 * @Auther zhangquansong
 * @Date 2020/3/31 19:51
 * @Version 1.0
 **/
@FeignClient(name = "cloud-dy-version", fallback = UserFeignClientFallback.class)
public interface UserFeignClient extends VersionFegin {


    /*@GetMapping(value = "/version/getUser")
    R<User> getUser();*/
}
