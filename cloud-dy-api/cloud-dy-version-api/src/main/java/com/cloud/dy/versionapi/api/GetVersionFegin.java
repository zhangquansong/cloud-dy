package com.cloud.dy.versionapi.api;


import com.cloud.dy.common.utils.R;
import com.cloud.dy.versionapi.param.GetVersionParam;
import com.cloud.dy.versionapi.vo.GetVersionVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName VersionFegin
 * @Description TODO
 * @Auther zhangquansong
 * @Date 2020/5/20 11:01
 * @Version 1.0
 **/
public interface GetVersionFegin {

    @PostMapping(value = "/version/getVersion")
    R<GetVersionVO> getVersion(@RequestBody GetVersionParam getVersionParam);
}
