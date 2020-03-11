package com.cloud.dy.common.utils;

import java.io.Serializable;

/**
 * @ClassName : R
 * @Author : zhangquansong
 * @Date : 2019/3/20 0020 上午 11:58
 * @Description :接口返回包装类
 **/
public class R<T> implements Serializable {

    private Integer code;//状态码
    private String message;//返回信息
    private T data;//返回数据

    public R() {
    }

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public R(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> R<T> response(Integer code, T data) {
        return new R(code, RestConstants.getMessageByCode(code).getMessage(), data);
    }

    public static <T> R<T> successResponse() {
        return new R(RestConstants.SUCCESS.getCode(),
                RestConstants.getMessageByCode(RestConstants.SUCCESS.getCode()).getMessage());
    }

    public static <T> R<T> successResponse(T data) {
        return new R(RestConstants.SUCCESS.getCode(),
                RestConstants.getMessageByCode(RestConstants.SUCCESS.getCode()).getMessage(), data);
    }

    public static <T> R<T> errorResponse() {
        return new R(RestConstants.ERROR.getCode(),
                RestConstants.getMessageByCode(RestConstants.ERROR.getCode()).getMessage());
    }

    public static <T> R<T> errorResponse(Integer code, String message) {
        return new R(code, message);
    }

    public static <T> R<T> errorResponse(String code, String message) {
        return new R(Integer.valueOf(code), message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
