package com.cloud.dy.user.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ClassName LoginParam
 * @Description TODO
 * @Auther zhangquansong
 * @Date 2020/5/16 15:33
 * @Version 1.0
 **/
@Data
public class LoginParam implements Serializable {
    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "密码不能为空")
    private String password;
}
