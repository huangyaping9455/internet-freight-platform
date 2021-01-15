package com.rising.rbac.dto.condition;


import lombok.Data;

/**
 * 描述：组织条件
 * <p>
 * 作者：李启云
 * 日期：2020-12-03
 */
@Data
public class OrganizationCondition {

    /**
     * 组织id
     */
    private Long organizationId;
    /**
     * 组织名称
     */
    private String organizationName;
}
