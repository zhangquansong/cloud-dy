package com.cloud.dy.common.exception;

/**
 * @ClassName : MyException
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:12
 * @Description :自定义异常
 **/
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MyException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public MyException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public MyException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
