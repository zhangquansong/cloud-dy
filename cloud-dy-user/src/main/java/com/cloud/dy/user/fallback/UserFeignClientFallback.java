package com.cloud.dy.user.fallback;

import com.cloud.dy.clients.vo.User;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.feign.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public R<User> getUser() {
        return R.errorResponse();
    }

    /*@Override
    public R<User> getUser() {
        return R.errorResponse();
    }*/

}
