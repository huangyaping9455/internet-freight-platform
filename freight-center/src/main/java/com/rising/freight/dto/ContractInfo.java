package com.rising.freight.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 描述：合同信息
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */

public class ContractInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean isDelete;
    private String writerName;
    private String contractNumber;
    private LocalDate contractExecutionDate;
    private LocalDate contractExpirationDate;
    private String firstParty;
    private String firstPartyAuthorizedAgent;
    private LocalDate firstPartySignDate;
    private String secondParty;
    private String secondPartyAuthorizedAgent;
    private LocalDate secondPartySignDate;
    private String placeOfDispatch;
    private String unloadingPoint;
    private String descriptionOfGoods;
    private Integer quantity;
    private String quantityUnit;
    private BigDecimal transportPrice;
    private Integer status;
    private String remark;
}