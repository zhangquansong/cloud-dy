package com.cloud.dy.common.utils;

import java.util.UUID;

/**
 * @ClassName : UuidUtil
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:18
 * @Description :uuid生成工具
 **/
public class UuidUtil {
    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
}

