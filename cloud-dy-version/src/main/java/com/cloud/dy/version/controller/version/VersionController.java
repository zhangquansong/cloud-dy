package com.cloud.dy.version.controller.version;

import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.versionapi.param.GetVersionParam;
import com.cloud.dy.versionapi.vo.GetVersionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/version")
public class VersionController {

    @PostMapping(value = "/getVersion")
    public R<GetVersionVO> getVersion(@RequestBody GetVersionParam getVersionParam) {
        log.info("version service getVersionParam :{} ", JSONObject.toJSONString(getVersionParam));
        GetVersionVO getVersionVO = new GetVersionVO();
        getVersionVO.setVersion(getVersionParam.getType());
        return R.successResponse(getVersionVO);
    }
}