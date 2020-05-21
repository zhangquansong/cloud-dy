package com.cloud.dy.clients.version;


import com.cloud.dy.clients.param.GetVersionParam;
import com.cloud.dy.clients.vo.User;
import com.cloud.dy.common.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName VersionFegin
 * @Description TODO
 * @Auther zhangquansong
 * @Date 2020/5/20 11:01
 * @Version 1.0
 **/
public interface VersionFegin {

    @GetMapping(value = "/version/getVersion")
    R<User> getVersion(@RequestBody GetVersionParam getVersionParam);
}
