package com.cloud.dy.user.fallback;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.feign.GetVersionFeignClient;
import com.cloud.dy.versionapi.param.GetVersionParam;
import com.cloud.dy.versionapi.vo.GetVersionVO;
import org.springframework.stereotype.Component;

@Component
public class GetVersionFeignClientFallback implements GetVersionFeignClient {


    @Override
    public R<GetVersionVO> getVersion(GetVersionParam getVersionParam) {
        return R.errorResponse();
    }
}
