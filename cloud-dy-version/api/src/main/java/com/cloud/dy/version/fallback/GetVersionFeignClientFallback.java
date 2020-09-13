package com.cloud.dy.version.fallback;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.version.feign.VersionFeignClient;
import com.cloud.dy.versionapi.param.GetVersionParam;
import com.cloud.dy.versionapi.param.SaveVersionParam;
import com.cloud.dy.versionapi.vo.GetVersionVO;
import org.springframework.stereotype.Component;

/**
 * @author zhangquansong
 * @description:
 * @date 2020/8/31 下午4:40
 */
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
