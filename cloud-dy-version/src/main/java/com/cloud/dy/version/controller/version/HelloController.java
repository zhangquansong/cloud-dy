package com.cloud.dy.version.controller.version;

import com.cloud.dy.clouddyapi.param.GetVersionParam;
import com.cloud.dy.clouddyapi.version.VersionFegin;
import com.cloud.dy.clouddyapi.vo.User;
import com.cloud.dy.common.utils.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements VersionFegin {

    @Override
    public R<User> getVersion(@RequestBody GetVersionParam getVersionParam) {
        return R.successResponse();
    }

    @Override
    public String helloVersion(@RequestParam("version") String version) {
        return "hello version is : " + version;
    }
}