package com.rising.freight.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：合同派单表
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */

public class ContractDispatch implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
    private Boolean isDelete;
    private String writerName;
    private Long contractId;
    private Long companyId;
    private String companyName;
    private String shipperName;
    private String goodsName;
    private Date startTransportDate;
    private Date endTransportDate;
    private String lineStart;
    private String lineEnd;
    private String goodsUnit;
    private Long goodsUumber;
    private BigDecimal goodsPrice;
    private Integer status;
}