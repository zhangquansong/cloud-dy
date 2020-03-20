package com.cloud.dy.user.handler;

/**
 * @author pc
 * @title: DiscoveryClientControllerBackHandler
 * @projectName cloud-dy
 * @date 2020/3/150:00
 */

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.dy.user.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 对应处理 BlockException 的函数名称 服务限流
 *
 * @Author: xlr
 * @Date: Created in 9:08 PM 2019/11/16
 */
@Slf4j
public class DiscoveryClientControllerBackHandler {

    public static String defaultMessage(BlockException e) {

        log.warn("DiscoveryClientControllerBackHandler  defaultMessage BlockException : {}", e);
        return "defaultMessage 服务限流，请稍后尝试";
    }

    public static String saveTx(User entity, BlockException e) {

        log.warn("DiscoveryClientControllerBackHandler  saveTx BlockException : {}", e);
        return "saveTx 服务限流，请稍后尝试";
    }
}