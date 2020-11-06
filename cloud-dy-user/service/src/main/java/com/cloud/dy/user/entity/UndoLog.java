package com.cloud.dy.user.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * undo_log
 * @author 
 */
@Data
public class UndoLog implements Serializable {
    /**
     * increment id
     */
    private Long id;

    /**
     * branch transaction id
     */
    private Long branchId;

    /**
     * global transaction id
     */
    private String xid;

    /**
     * undo_log context,such as serialization
     */
    private String context;

    /**
     * 0:normal status,1:defense status
     */
    private Integer logStatus;

    /**
     * create datetime
     */
    private Date logCreated;

    /**
     * modify datetime
     */
    private Date logModified;

    /**
     * rollback info
     */
    private byte[] rollbackInfo;

    private static final long serialVersionUID = 1L;
}