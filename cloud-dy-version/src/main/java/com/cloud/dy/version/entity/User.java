package com.cloud.dy.version.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("user_login_name")
    private String userLoginName;
    @TableField("user_name")
    private String userName;
    @TableField("user_phone")
    private String userPhone;
    @TableField("user_sex")
    private Integer userSex;
    @TableField("user_id_card")
    private String userIdCard;
    @TableField("user_face")
    private String userFace;
    @TableField("user_code")
    private String userCode;
    @TableField("user_type")
    private Integer userType;
    @TableField("user_password")
    private String userPassword;
    @TableField("user_asset")
    private BigDecimal userAsset;
    @TableField("user_address")
    private String userAddress;
    @TableField("user_longin_last_time")
    private Date userLonginLastTime;
    @TableField("user_status")
    private Integer userStatus;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("user_version")
    private Long userVersion;

}
