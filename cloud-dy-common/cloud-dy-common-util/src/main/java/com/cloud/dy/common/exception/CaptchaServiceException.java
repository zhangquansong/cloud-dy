package com.cloud.dy.common.exception;

/**
 * @ClassName : CaptchaServiceException
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:11
 * @Description :
 **/
public class CaptchaServiceException extends RuntimeException {

    private static final long serialVersionUID = 2864817652714842988L;

    private Throwable cause;

    public CaptchaServiceException(String message) {
        super(message);
    }

    public CaptchaServiceException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

    public CaptchaServiceException(Throwable cause) {
        super(cause.getMessage());
        this.cause = cause;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }
}