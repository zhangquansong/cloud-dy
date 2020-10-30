package com.cloud.dy.version.controller.version;

import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.common.utils.R;
import com.cloud.dy.version.entity.Version;
import com.cloud.dy.version.service.VersionExtService;
import com.cloud.dy.version.service.VersionService;
import com.cloud.dy.versionapi.param.GetVersionParam;
import com.cloud.dy.versionapi.param.SaveVersionParam;
import com.cloud.dy.versionapi.vo.GetVersionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhangquansong
 * @Description : 用户控制层
 * @Date 9:50 2020/3/11
 **/
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


    @PostMapping("/save")
    @ResponseBody
    public R<Boolean> saveVersion(@RequestBody SaveVersionParam saveVersionParam) {
        log.info("save -- param : {}", JSONObject.toJSONString(saveVersionParam));
        Version version = new Version();
        version.setVersion(saveVersionParam.getVersion());
        versionExtService.saveVersion(version);
        return R.successResponse(Boolean.TRUE);
    }


}