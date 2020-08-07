package com.cloud.dy.version.controller.version;

import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.version.service.VersionExtService;
import com.cloud.dy.version.service.VersionService;
import com.cloud.dy.versionapi.param.GetVersionParam;
import com.cloud.dy.versionapi.param.SaveVersionParam;
import com.cloud.dy.versionapi.vo.GetVersionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/version")
public class VersionController {
    @Autowired
    private VersionService versionService;
    @Autowired
    private VersionExtService versionExtService;

    @PostMapping(value = "/getVersion")
    public R<GetVersionVO> getVersion(@RequestBody GetVersionParam getVersionParam) {
        log.info("version service getVersionParam :{} ", JSONObject.toJSONString(getVersionParam));
        GetVersionVO getVersionVO = new GetVersionVO();
        getVersionVO.setVersion(getVersionParam.getType());
        return R.successResponse(getVersionVO);
    }


    @PostMapping(value = "/save")
    @Transactional
    public R<Boolean> saveVersion(@RequestBody SaveVersionParam saveVersionParam) {
        versionExtService.saveVersion(null);
        return R.successResponse(Boolean.TRUE);
    }
}