package com.cloud.dy.version.service.impl;

import com.cloud.dy.version.entity.Version;
import com.cloud.dy.version.service.VersionExtService;
import com.cloud.dy.version.service.VersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhangquansong
 * @Date 21:24 2020/3/7
 * @Description :   用户基本CURD操作实现类
 * @return
 **/
@Slf4j
@Service
public class VersionExtServiceImpl implements VersionExtService {


    @Autowired
    private VersionService versionService;

    @Transactional
    @Override
    public void saveVersion(Version verion) {
        log.info("---> start save version <---");
        Version version = new Version();
        java.util.Random rd = new java.util.Random();
        int sj = rd.nextInt(2) + 1;//因为是从0开始的，排除0就+1
        version.setVersion(String.valueOf(sj));
        version.setNum(sj);
//        log.error("1/0,,,,");
//        int i = 1 / 0;
        versionService.saveVersion(version);
    }


}