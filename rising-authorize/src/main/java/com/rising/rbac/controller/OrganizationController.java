package com.rising.rbac.controller;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.rbac.domain.Admin;
import com.rising.rbac.dto.OrganizationInfo;
import com.rising.rbac.repository.support.BaseController;
import com.rising.rbac.service.OrganizationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 描述：组织控制器
 * <p>
 * 作者：李启云
 * 日期：2020-11-27
 */
@Api(tags = "组织机构管理API")
@RestController
@RequestMapping("/sys/organization")
public class OrganizationController extends BaseController {


    @Autowired
    private OrganizationService organizationService;


    @ResponseResult
    @GetMapping("organizationList")
    public List<OrganizationInfo> organizationList() throws Exception {
        List<OrganizationInfo> resourceList = organizationService.getOrganizationList(admin.getId());
        return resourceList;
    }

    @ResponseResult
    @GetMapping("organizationRootList")
    public List<OrganizationInfo> organizationRootList() throws Exception {
        List<OrganizationInfo> organizationInfoList = organizationService.getOrganizationList(admin.getId());
        OrganizationInfo organizationInfo = organizationService.findByName("平台");
        organizationInfoList.add(organizationInfo);
        return organizationInfoList;
    }

    /**
     * 创建：李启云
     * 日期：2020-11-30
     * 描述：创建组织机构
     *
     * @param organizationInfo 组织信息
     * @return {@link OrganizationInfo }
     */
    @PostMapping
    @ResponseResult
    public OrganizationInfo create(@RequestBody OrganizationInfo organizationInfo) {

        return organizationService.create(organizationInfo);

    }

    /**
     * 创建：李启云
     * 日期：2020-12-09
     * 描述：得到信息
     *
     * @param organizationId 组织id
     * @return {@link OrganizationInfo }
     */
    @ResponseResult
    @GetMapping("/{id}")
    public OrganizationInfo getInfo(@PathVariable("id") Long organizationId) {
        return organizationService.getInfo(admin, organizationId);
    }

    @GetMapping("/getInfoByOldCompanyId/{id}")
    public OrganizationInfo getInfoByOldCompanyId(@PathVariable("id") Long oldCompanyId) {
        return organizationService.getInfoByOldCompanyId(oldCompanyId);
    }

    /**
     * 创建：李启云
     * 日期：2020-11-30
     * 描述：更新组织机构
     *
     * @param info 信息
     * @return {@link OrganizationInfo }
     */
    @ResponseResult
    @PutMapping("/{id}")
    public OrganizationInfo update(@RequestBody OrganizationInfo info) {
        return organizationService.update(info);
    }


    @ResponseResult
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        organizationService.delete(id);
    }


}
