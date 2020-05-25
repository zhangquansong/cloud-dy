package com.cloud.dy.user.feign;

import com.cloud.dy.user.fallback.GetVersionFeignClientFallback;
import com.cloud.dy.versionapi.api.GetVersionFegin;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ClassName UserFeignClient
 * @Description
 * @Auther zhangquansong
 * @Date 2020/3/31 19:51
 * @Version 1.0
 **/
@FeignClient(name = "cloud-dy-version", fallback = GetVersionFeignClientFallback.class)
public interface GetVersionFeignClient extends GetVersionFegin {

}
