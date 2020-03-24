package com.cloud.dy.version.handler;

import com.cloud.dy.user.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pc
 * @title: DiscoveryClientControllerFallBackHandler
 * @projectName cloud-dy
 * @date 2020/3/150:04
 */
@Slf4j
public class DiscoveryClientControllerFallBackHandler {

    public static String defaultMessage(Throwable t) {
        log.warn("DiscoveryClientControllerFallBackHandler defaultMessage Throwable : {}", t);

        return "defaultMessage 服务降级，请稍后尝试";
    }


    public static String saveTx(User entity, Throwable t) {

        log.warn("DiscoveryClientControllerFallBackHandler saveTx Throwable : {}", t);

        return "saveTx 服务降级，请稍后尝试";
    }
}
