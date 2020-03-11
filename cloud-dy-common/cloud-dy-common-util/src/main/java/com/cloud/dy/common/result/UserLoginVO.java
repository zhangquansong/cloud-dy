package com.cloud.dy.common.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName : UserLoginVO
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:14
 * @Description :用户登录返回vo
 **/
@Data
public class UserLoginVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userLoginName;
    private String userName;
    private String userPhone;
    private Integer userSex;
    private String userIdCard;
    private String userFace;
    private String userCode;
    private Integer userType;
    private String userAddress;
    private String token;
    private Date expireTime;

}
