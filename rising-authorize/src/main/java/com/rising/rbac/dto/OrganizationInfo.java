package com.rising.rbac.dto;

import lombok.Data;

import java.io.Serializable;
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

    private Long id;
    private String name;
    private Long parentId;
    private String parentName;

    private Integer type;
    private String operator;

    private Set<RoleInfo>  roleList;

    private Set<Long> roleIds;

    /**
     * 子节点
     */
    private List<OrganizationInfo> children = new ArrayList<>();


}
