/**
 *
 */
package com.rising.rbac.service;


import com.rising.rbac.domain.Admin;
import com.rising.rbac.domain.Role;
import com.rising.rbac.dto.RoleInfo;
import com.rising.rbac.dto.condition.RoleCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 描述：角色
 * <p>
 * 作者：李启云
 * 日期：2020-11-24
 */
public interface IRoleService {

    /**
     * 创建角色
     *
     * @param roleInfo
     * @return
     */
    RoleInfo create(RoleInfo roleInfo);

    /**
     * 修改角色
     *
     * @param roleInfo
     * @return
     */
    RoleInfo update(RoleInfo roleInfo);

    /**
     * 删除角色
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 获取角色详细信息
     *
     * @param id
     * @return
     */
    RoleInfo getInfo(Long id);

    /**
     * 查询所有角色
     *
     * @return list
     */
    List<RoleInfo> findAll();

    List<RoleInfo> findByCondition(Admin admin,RoleCondition condition);

    /**
     * 创建：李启云
     * 日期：2020-11-27
     * 描述：获取角色资源
     *
     * @param id id
     * @return {@link String[] }
     */
    String[] getRoleResources(Long id);


    /**
     * 创建：李启云
     * 日期：2020-11-27
     * 描述：获取角色资源列表
     *
     * @param id id
     * @return {@link RoleInfo }
     */
    RoleInfo getRoleResourceList(Long id);

     String[] getOrganizations(Long id);

    /**
     * 码农：李齐云
     * 日期：2021-02-22
     * 描述：设置角色资源
     * <p>
     * 返回值：
     *
     * @param id       id
     * @param roleInfo 角色信息
     */
    void setRoleResources(Long id, RoleInfo roleInfo);

    /**
     * 创建：李启云
     * 日期：2020-11-24
     * 描述：分页查询
     *
     * @param condition 条件
     * @param pageable  可分页
     * @return {@link Page<Role> }
     */
    Page<RoleInfo> page(Admin admin,RoleCondition condition, Pageable pageable);

    void deleteByIds(List<Long> ids);
}
