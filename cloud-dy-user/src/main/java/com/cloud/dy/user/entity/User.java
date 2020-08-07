package com.cloud.dy.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
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

    private Integer isDelete;

    private Long userVersion;

    private static final long serialVersionUID = 1L;
}