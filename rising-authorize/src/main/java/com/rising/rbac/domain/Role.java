/**
 *
 */
package com.rising.rbac.domain;

import com.rising.common.web.annotation.Comment;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 角色信息
 *
 * @author liqiyun
 */
@Entity
@Table(name = "sys_role")
public class Role extends Model implements Serializable {


    /**
     * 角色名称
     */
    @Column(length = 20, nullable = false)
    @Comment("角色名称")
    @ApiModelProperty(value = "角色名称")
    private String name;
    /**
     * 角色拥有权限的资源集合
     */
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private Set<RoleResource> resources = new HashSet<>();
    /**
     * 角色的用户集合
     */
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private Set<RoleAdmin> admins = new HashSet<>();

    /**
     * 角色包含的组
     */
    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<RoleOrganization> organizations = new ArrayList<>();


    public List<Role> getRole() {

        return organizations.stream().map(RoleOrganization::getRole).collect(Collectors.toList());
    }


    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<RoleOrganization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<RoleOrganization> organizations) {
        this.organizations = organizations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RoleResource> getResources() {
        return resources;
    }

    public void setResources(Set<RoleResource> resources) {
        this.resources = resources;
    }

    public Set<RoleAdmin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<RoleAdmin> admins) {
        this.admins = admins;
    }
}
