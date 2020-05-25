package com.cloud.dy.version.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author zhangquansong
 * @Date 21:20 2020/3/7
 * @Description :
 * @return
 **/
@Data
@ToString
@Accessors(chain = true)
public class Version implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("version")
    private String version;
    @TableField("num")
    private Integer num;

}
