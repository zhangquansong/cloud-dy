package com.cloud.dy.clouddyapi.version;


import com.cloud.dy.clouddyapi.param.GetVersionParam;
import com.cloud.dy.clouddyapi.vo.User;
import com.cloud.dy.common.utils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName VersionFegin
 * @Description TODO
 * @Auther zhangquansong
 * @Date 2020/5/20 11:01
 * @Version 1.0
 **/
public interface VersionFegin {

    @PostMapping(value = "/version/getVersion")
    R<User> getVersion(@RequestBody GetVersionParam getVersionParam);

    @RequestMapping(value = "/helloVersion", method = RequestMethod.GET)
    String helloVersion(@RequestParam("version") String version);
}
