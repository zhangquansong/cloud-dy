package com.cloud.dy.version.service.impl;

import com.cloud.dy.version.entity.Version;
import com.cloud.dy.version.mapper.VersionMapper;
import com.cloud.dy.version.service.VersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhangquansong
 * @Date 21:24 2020/3/7
 * @Description :   用户基本CURD操作实现类
 * @return
 **/
@Slf4j
@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    private VersionMapper versionMapper;

    @Override
    public void saveVersion(Version version) {
        versionMapper.insert(version);
    }
}