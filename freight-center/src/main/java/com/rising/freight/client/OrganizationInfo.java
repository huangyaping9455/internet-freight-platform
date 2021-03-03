package com.rising.freight.client;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.management.relation.RoleInfo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: Organization
 * @date 2020/5/12 11:01
 */

@Data
public class OrganizationInfo implements Serializable {

    private String id;
    private Long oldCompanyId;
    private String name;
    private Long parentId;
    private String parentName;
    private Integer type;
    private String operator;

    //////////
    @ApiModelProperty(value = "排序序号")
    private int sort;
    @ApiModelProperty(value = "当前版本")
    private String version;
    @ApiModelProperty(value = "续期时间")
    private LocalDateTime renewalDate;
    @ApiModelProperty(value = "到期时间")
    private LocalDateTime expirationDate;
    @ApiModelProperty(value = "公司地区")
    private String companyArea;
    @ApiModelProperty(value = "公司地址")
    private String companyAddress;
    @ApiModelProperty(value = "营业执照-图片ID")
    private String businessLicenseId;
    @ApiModelProperty(value = "法人代表")
    private String legalRepresentative;
    @ApiModelProperty(value = "公司电话")
    private String companyPhone;
    @ApiModelProperty(value = "邮箱")
    private String mailbox;
    @ApiModelProperty(value = "公司规模")
    private String companySize;
    @ApiModelProperty(value = "所属行业")
    private String industry;
    @ApiModelProperty(value = "备注")
    private String remarks;
    @ApiModelProperty(value = "当前余额")
    private BigDecimal balance;
    @ApiModelProperty(value = "信用代码")
    private String creditId;



}
