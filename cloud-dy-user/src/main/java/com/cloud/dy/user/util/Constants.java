package com.cloud.dy.user.util;

/**
 * @Author zhangquansong
 * @Date 21:26 2020/3/7
 * @Description :   系统常量类
 * @return
 **/
public class Constants {

    /**
     * 登录标识前缀
     */
    public static final String REDIS_API_PREFIX = "@@CLTUser";
    public static final String KEY_NAME_TOKEN = "token";

    /**
     * 常用的0,1值
     */
    public static final Integer INTEGER_VALUE_0 = 0;
    public static final Integer INTEGER_VALUE_1 = 1;


    /**
     * 删除状态,0:未删除、1:删除
     */
    public static final Integer IS_DELETE_0 = 0;
    public static final Integer IS_DELETE_1 = 1;

    /**
     * 用户状态 0:启用、1:黑名单
     */
    public static final Integer USER_STATUS_0 = 0;
    public static final Integer USER_STATUS_1 = 1;

    /**
     * repeatData 重复提交，AttributeName
     */
    public static final String REPEATDATA = "repeatData";


    // ==========================移动端Header请求参数=================================
    /**
     * app包名
     */
    public static final String APP_PACKAGE_NAME = "appPackageName";

    /**
     * app版本号
     */
    public static final String APP_VERSION = "version";

    /**
     * 请求方法版本号
     */
    public static final String APP_METHOD_VERSION = "methodVersion";

    /**
     * 渠道名称
     */
    public static final String APP_CHANNEL = "channel";

    /**
     * 渠道签名
     */
    public static final String APP_CHANNEL_SIGNA = "channelSigna";

    /**
     * 签名
     */
    public static final String APP_IMEI_SIGNA = "imeiSigna";

    /**
     * 登录标识
     */
    public static final String APP_TOKEN = "token";

    /**
     * 请求签名
     */
    public static final String APP_SIGN = "sign";

    /**
     * 时间戳
     */
    public static final String APP_TIMESTAMP = "timestamp";

    /**
     * 设备编号imei
     */
    public static final String APP_DEVICE_ID = "deviceId";

    /**
     * 设备ID签名
     */
    public static final String APP_DEVICEID_SIGNA = "deviceIdSigna";

    /**
     * 设备标识
     */
    public static final String APP_DEVICE_TOKEN = "deviceToken";

    /**
     * 设备标识签名
     */
    public static final String APP_DEVICE_TOKEN_SIGNA = "deviceTokenSigna";

    /**
     * 移动设备类型
     */
    public static final String APP_DEVICE_TYPE = "deviceType";

    // ============================移动端Header请求参数END=============================

    /**
     * 全局黑名单 key
     */
    public static final String GLOB_BLACK_LIST = "glob_black_list_";

    /**
     * 黑名单 key
     */
    public static final String SMS_BLACK_LIST = "req_sms_black_list_";

    /***
     * Redis默认增长值
     */
    public static final Long INIT_INCREMENT_VALUE = 1L;

}