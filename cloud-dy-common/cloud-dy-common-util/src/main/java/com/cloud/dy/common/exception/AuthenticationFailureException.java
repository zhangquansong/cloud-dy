package com.cloud.dy.common.exception;

import lombok.Data;

/**
 * @ClassName : AuthenticationFailureException
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:09
 * @Description :登录失效异常:401
 **/
@Data
public class AuthenticationFailureException extends RuntimeException {

    private static final long serialVersionUID = 4745836273751186869L;
    private String msg;
    private int code = 401;

    public AuthenticationFailureException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AuthenticationFailureException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

}
