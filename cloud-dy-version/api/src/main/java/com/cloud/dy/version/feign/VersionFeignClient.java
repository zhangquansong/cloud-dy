package com.cloud.dy.version.feign;

import com.cloud.dy.version.fallback.GetVersionFeignClientFallback;
import com.cloud.dy.versionapi.api.VersionFegin;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author zhangquansong
 * @description:
 * @date 2020/8/31 下午4:40
 */
@FeignClient(name = "cloud-dy-version", fallback = GetVersionFeignClientFallback.class)
public interface VersionFeignClient extends VersionFegin {

}
