package com.cloud.dy.version.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * version
 * @author 
 */
@Data
public class Version implements Serializable {
    private Long id;

    private String version;

    private Integer num;

    private static final long serialVersionUID = 1L;
}