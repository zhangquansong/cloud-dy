package com.cloud.dy.user.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author zhangquansong
 * @Date 21:20 2020/3/7
 * @Description :  用户信息
 * @return
 **/
@Data
@ToString
@Accessors(chain = true)
public class LoginVO implements Serializable {

    private static final long serialVersionUID = 1L;

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

}
