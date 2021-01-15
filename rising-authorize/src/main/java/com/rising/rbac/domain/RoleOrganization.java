package com.rising.rbac.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: UsergroupRole
 * @date 2020/5/12 10:27
 */

@Entity
@Table(name = "sys_role_organization")
public class RoleOrganization implements Serializable {

    @ApiModelProperty(value = "数据库表主键")
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Organization organization;
    @ManyToOne
    private Role role;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
