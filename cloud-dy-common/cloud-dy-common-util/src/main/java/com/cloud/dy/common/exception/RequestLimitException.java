package com.cloud.dy.common.exception;

/**
 * @ClassName : RequestLimitException
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:13
 * @Description :HTTP请求超出设定的限制异常
 **/
public class RequestLimitException extends MyException {
    private static final long serialVersionUID = 1364225358754654702L;

    public RequestLimitException() {
        super("HTTP请求超出设定的限制");
    }

    public RequestLimitException(String message) {
        super(message);
    }

    public RequestLimitException(String message, Throwable cause) {
        super(message, cause);
    }
}