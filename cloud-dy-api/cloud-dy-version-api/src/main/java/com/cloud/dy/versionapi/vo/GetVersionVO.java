package com.cloud.dy.versionapi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhangquansong
 * @Date 21:20 2020/3/7
 * @Description :  用户信息表
 * @return
 **/
@Data
public class GetVersionVO implements Serializable {

    private String version;
}
