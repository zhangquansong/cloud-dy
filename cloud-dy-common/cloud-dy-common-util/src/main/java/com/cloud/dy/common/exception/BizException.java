package com.cloud.dy.common.exception;

import lombok.Data;

/**
 * @ClassName : BizException
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:10
 * @Description :业务异常
 **/
@Data
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -298311232780808293L;

    private int code = 400;

    private String message;

    public BizException() {
        super();
    }

    public BizException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BizException(int code) {
        this.code = code;
    }

}
