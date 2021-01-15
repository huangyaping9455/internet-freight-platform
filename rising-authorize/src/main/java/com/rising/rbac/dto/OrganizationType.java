package com.rising.rbac.dto;

/**
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: OrganizationType
 * @date 2020/5/26 15:51
 */
public enum OrganizationType {
    //公司
    COMPANY(0),
    //部门
    DEPARTMENT(1);

    private Integer value;

    OrganizationType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
