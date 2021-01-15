/**
 *
 */
package com.rising.rbac.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色用户关系表
 *
 * @author 李启云
 */
@Entity
@Table(name = "sys_role_admin")
public class RoleAdmin implements Serializable {


    @ApiModelProperty(value = "数据库表主键")
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "角色")
    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @ApiModelProperty(value = "管理员")
    @ManyToOne(cascade = CascadeType.ALL)
    private Admin admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
