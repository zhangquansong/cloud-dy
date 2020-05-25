package com.cloud.dy.user.fallback;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.feign.VersionFeignClient;
import com.cloud.dy.versionapi.param.GetVersionParam;
import com.cloud.dy.versionapi.param.SaveVersionParam;
import com.cloud.dy.versionapi.vo.GetVersionVO;
import org.springframework.stereotype.Component;

@Component
public class GetVersionFeignClientFallback implements VersionFeignClient {


    @Override
    public R<GetVersionVO> getVersion(GetVersionParam getVersionParam) {
        return R.errorResponse();
    }

    @Override
    public R<Boolean> saveVersion(SaveVersionParam saveVersionParam) {
        return R.errorResponse();
    }
}
