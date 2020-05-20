package com.cloud.dy.clients.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author zhangquansong
 * @Date 21:20 2020/3/7
 * @Description :  用户信息表
 * @return
 **/
@Data
@ToString
public class User implements Serializable {

    private Long id;
    private String userLoginName;
    private String userName;
    private String userPhone;
    private Integer userSex;
    private String userIdCard;
    private String userFace;
    private String userCode;
    private Integer userType;
    private String userPassword;
    private BigDecimal userAsset;
    private String userAddress;
    private Date userLonginLastTime;
    private Integer userStatus;
    private Date createTime;
    private Date updateTime;
    private Long userVersion;

}
