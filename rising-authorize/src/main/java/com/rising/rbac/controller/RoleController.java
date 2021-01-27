/**
 *
 */
package com.rising.rbac.controller;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.rbac.domain.Role;
import com.rising.rbac.dto.RoleInfo;
import com.rising.rbac.dto.condition.RoleCondition;
import com.rising.rbac.repository.support.BaseController;
import com.rising.rbac.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李启云
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    /**
     * 创建角色
     *
     * @param roleInfo
     * @return
     */
    @ResponseResult
    @PostMapping
    public RoleInfo create(@RequestBody RoleInfo roleInfo) {
        return roleService.create(roleInfo);
    }

    /**
     * 修改角色信息
     *
     * @param roleInfo
     * @return
     */
    @PutMapping("/{id}")
    public RoleInfo update(@RequestBody RoleInfo roleInfo) {
        return roleService.update(roleInfo);
    }

    /**
     * 创建：李启云
     * 日期：2020-11-27
     * 描述：删除
     *
     * @param roleIds 角色id
     * @return
     */
    @ResponseResult
    @DeleteMapping
    public void delete(@RequestBody Long[] roleIds) {
        List<Long> ids = Arrays.asList(roleIds);
        roleService.deleteByIds(ids);
    }

    /**
     * 获取角色详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public RoleInfo getInfo(@PathVariable Long id) {
        return roleService.getInfo(id);
    }

    /**
     * 获取所有角色
     */
    @GetMapping
    public List<RoleInfo> findAll() {
        return roleService.findAll();
    }

    /**
     * 获取角色的所有资源
     *
     * @param id
     * @return
     */
    @ResponseResult
    @GetMapping("/{id}/resource")
    public RoleInfo getRoleResources(@PathVariable Long id) {
        return roleService.getRoleResourceList(id);
    }

    /**
     * 创建：李启云
     * 日期：2020-11-27
     * 描述：创建角色资源
     *
     * @param id       id
     * @param roleInfo 角色信息
     * @return
     */
    @ResponseResult
    @PostMapping("/{id}/resource")
    public void createRoleResource(@PathVariable Long id, @RequestBody RoleInfo roleInfo) {
        roleService.setRoleResources(id,  roleInfo);
    }

    /**
     * 创建：李启云
     * 日期：2020-11-24
     * 描述：分页查询
     *
     * @param condition 条件
     * @param pageable  可分页
     * @return {@link Page<Role> }
     */
    @ResponseResult
    @GetMapping("/page")
    public Page<RoleInfo> page(RoleCondition condition, Pageable pageable) {

        return roleService.page(admin, condition, pageable);
    }

}
