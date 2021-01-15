/**
 *
 */
package com.rising.rbac.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 角色资源关系表
 *
 * @author 李启云
 */
@Table(name = "sys_role_resource")
@Entity
public class RoleResource extends Model {


    /**
     * 角色
     */
    @ManyToOne
    private Role role;
    /**
     * 资源
     */
    @ManyToOne
    private Resource resource;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
