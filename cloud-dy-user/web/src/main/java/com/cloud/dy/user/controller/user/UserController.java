package com.cloud.dy.user.controller.user;

import com.cloud.dy.common.utils.R;
import com.cloud.dy.user.entity.UndoLog;
import com.cloud.dy.user.entity.User;
import com.cloud.dy.user.mapper.UndoLogDao;
import com.cloud.dy.user.service.UserExtService;
import com.cloud.dy.user.service.UserService;
import com.cloud.dy.versionapi.param.SaveVersionParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhangquansong
 * @Description : 用户控制层
 * @Date 9:50 2020/3/11
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserExtService userExtService;

    @Autowired
    private UserService userService;

    @Autowired
    private UndoLogDao undoLogDao;

    @PostMapping("/saveVersion")
    @ResponseBody
    public R<Boolean> saveVersion(@RequestBody SaveVersionParam saveVersionParam) {
        return userExtService.saveUser(saveVersionParam);
    }


    @GetMapping("/list")
    @ResponseBody
    public List<User> list() {
        return userService.list();
    }


    @GetMapping("/undoLog/list")
    @ResponseBody
    public UndoLog undoLog() {
        return undoLogDao.selectByPrimaryKey(null);
    }
}