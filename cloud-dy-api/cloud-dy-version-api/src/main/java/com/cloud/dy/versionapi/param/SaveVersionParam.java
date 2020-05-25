package com.cloud.dy.versionapi.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SaveVersionParam
 * @Auther zhangquansong
 * @Date 2020/5/21 17:46
 * @Version 1.0
 **/
@Data
public class SaveVersionParam implements Serializable {
    private String version;
}
