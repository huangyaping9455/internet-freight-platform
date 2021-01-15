package com.rising.freight.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述：附件管理表
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */

public class Attachment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean isDelete;
    private String writerName;
    private String fileName;
    private String serverPath;
    private String recordName;
    private Long recordId;
    private String recordType;
}