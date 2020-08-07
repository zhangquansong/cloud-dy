package com.cloud.dy.version.service;

import com.cloud.dy.version.entity.Version;

/**
 * @Author zhangquansong
 * @Date 21:23 2020/3/7
 * @Description :     用户基本操作CURD接口
 * @return
 **/
public interface VersionExtService {


    void saveVersion(Version version);
}