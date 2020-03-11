package com.cloud.dy.common.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @ClassName : RestConstants
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:19
 * @Description : 返回状态码和提示语
 **/
public enum RestConstants {
    /**
     * 系统提示
     */
    SUCCESS(Constants.INTEGER_VALUE_0, "成功"), ERROR(Constants.INTEGER_VALUE_1, "失败"),
    OTHER(1000, "其他错误"), DEFAULT(10000, "默认错误"),

    /**
     * 业务提示(10001~90000)
     */
    BIZ_USER_LOGIN_10001(10001, "用户名或者密码错误"), BIZ_TOKEN_NULL_10002(10002, "token为空"),
    BIZ_TOKEN_EFFECT_10003(10003, "token失效"), BIZ_TOKEN_EXCEPTION_10004(10004, "token异常"),
    BIZ_USER_NULL_10005(10005, "用户不存在"), BIZ_SIGN_NULL_10006(10006, "sign为空"),
    BIZ_TIMESTAMP_NULL_10007(10007, "timeStamp为空"), REQUEST_INVALID_CORE_10008(10008, "签名检查异常:非法请求"),
    REQUEST_EXPIRED_CODE_10009(10009, "签名检查异常:请求已过期,请检查系统时间"), REQUEST_SIGN_ERROR_CODE_10010(10010, "签名检查异常:签名错误"),
    REQUEST_PARAM_ERROR_CODE_10011(10011, "签名检查异常:参数错误"), SAMEURLDATA_REPEAT_10012(10012, "请勿重复请求"),
    BLACK_USER_10013(10013, "账户被限制，请联系客服");

    private final Integer code;//状态吗
    private final String message;//信息

    RestConstants(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static RestConstants getMessageByCode(Integer code) {
        if (null == code) {
            return DEFAULT;
        }
        return Arrays.stream(RestConstants.values()).filter(a -> a.getCode().equals(code))
                .collect(Collectors.toList()).get(Constants.INTEGER_VALUE_0);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
