package com.cloud.dy.user.entity;

import lombok.Data;

/**
 * @ClassName Balance
 * @Description TODO
 * @Auther zhangquansong
 * @Date 2020/3/5 11:31
 * @Version 1.0
 **/
@Data
public class Balance {

    private Integer a;
    private Integer b;
    private Integer c;
    private String d;

    public Balance(Integer a, Integer b, Integer c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
