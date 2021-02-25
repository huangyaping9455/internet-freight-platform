/**
 *
 */
package com.rising.rbac.controller;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.common.web.result.ResultCode;
import com.rising.rbac.domain.Admin;
import com.rising.rbac.domain.Organization;
import com.rising.rbac.dto.AdminInfo;
import com.rising.rbac.dto.OrganizationInfo;
import com.rising.rbac.dto.condition.AdminCondition;
import com.rising.rbac.repository.support.BaseController;
import com.rising.rbac.service.impl.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李启云
 */

@Api(value = "用户Api",tags = "管理员API")
@RestController
@RequestMapping("/sys/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminServiceImpl adminService;

    @ResponseResult
    @ApiOperation(value = "获取当前登录的管理员信息", response = AdminInfo.class)
    @GetMapping("/me")
    public AdminInfo me() {
        AdminInfo info = new AdminInfo();
        info.setUsername(admin.getUsername());
        info.setName(admin.getName());
        info.setId(admin.getId());
        info.setOrganizationId(admin.getOrganization().getId());
        info.setOrganizationName(admin.getOrganization().getName());
        OrganizationInfo organizationInfo = new OrganizationInfo();
        BeanUtils.copyProperties(admin.getOrganization(),organizationInfo);
        info.setOrganization(organizationInfo);
        return info;
    }

    @GetMapping("/me1")
    public AdminInfo me(Authentication user) {
        AdminInfo info = new AdminInfo();
        info.setUsername(user.getName());
        return info;
    }

    /**
     * 创建管理员
     *
     * @param adminInfo
     * @return
     */
    @ResponseResult
    @PostMapping
    public AdminInfo create(@RequestBody AdminInfo adminInfo) {

        Admin byUsername = adminService.findByUsername(adminInfo.getUsername());
        if (!StringUtils.isEmpty(byUsername)) {
            cast(ResultCode.DATA_ALREADY_EXISTED);

        }

        return adminService.create(adminInfo);
    }

    /**
     * 修改管理员信息
     *
     * @param adminInfo
     * @return
     */
    @ResponseResult
    @PutMapping("/{id}")
    public AdminInfo update(@RequestBody AdminInfo adminInfo) {
        return adminService.update(adminInfo);
    }


    /**
     * 创建：李启云
     * 日期：2020-11-24
     * 描述：删除(1-n)
     *
     * @param adminIds 管理员id
     * @return
     */
    @ResponseResult
    @DeleteMapping
    public void delete(@RequestBody Long[] adminIds) {
        List<Long> longs = Arrays.asList(adminIds);
        adminService.deleteByIds(longs);
    }

    /**
     * 获取管理员详情
     *
     * @param id
     * @return
     */
    @ResponseResult
    @GetMapping("/{id}")
    public AdminInfo getInfo(@PathVariable Long id) {
        return adminService.getInfo(id);
    }

    /**
     * 分页查询管理员
     *
     * @param pageable
     * @return
     */
    @ResponseResult
    @GetMapping
    public Page<AdminInfo> query(AdminCondition condition, Pageable pageable) {
        return adminService.query(admin.getUsername(), condition, pageable);
    }


    @ApiOperation(value = "登录")
    @PostMapping("/authentication/form")
    public void login(){
    }
}
