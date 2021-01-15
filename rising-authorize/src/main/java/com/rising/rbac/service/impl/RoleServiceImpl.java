/**
 *
 */
package com.rising.rbac.service.impl;


import com.rising.common.web.exception.ExceptionCast;
import com.rising.common.web.result.ResultCode;
import com.rising.rbac.controller.support.QueryResultConverter;
import com.rising.rbac.domain.*;
import com.rising.rbac.dto.RoleInfo;
import com.rising.rbac.dto.condition.RoleCondition;
import com.rising.rbac.repository.*;
import com.rising.rbac.repository.spec.RoleSpec;
import com.rising.rbac.service.IRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author liqiyun
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RoleResourceRepository roleResourceRepository;

    @Autowired
    private RoleOrganizationRepository roleOrganizationRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    /**
     * @see IRoleService#create(RoleInfo)
     */
    @Override
    public RoleInfo create(RoleInfo info) {
        Role role = new Role();
        BeanUtils.copyProperties(info, role);
        info.setId(roleRepository.save(role).getId());
        if (!StringUtils.isBlank(info.getOrganizationId() + "")) {
            //创建关联角色和用户组
            createRoleOrganization(role, info);

        }
        for (Long resourceId : info.getResourceIds()) {
            RoleResource roleResource = new RoleResource();
            roleResource.setRole(role);
            roleResource.setResource(resourceRepository.getOne(resourceId));
            roleResourceRepository.save(roleResource);
        }

        return info;
    }


    /**
     * 创建：李启云
     * 日期：2020-12-03
     * 描述：创建角色组织
     *
     * @param role     角色
     * @param roleInfo 角色信息
     * @return
     */
    private void createRoleOrganization(Role role, RoleInfo roleInfo) {
        RoleOrganization roleOrganization = new RoleOrganization();
        Organization organization = organizationRepository.findById(roleInfo.getOrganizationId()).get();
        roleOrganization.setRole(role);
        roleOrganization.setOrganization(organization);
        roleOrganizationRepository.save(roleOrganization);


    }

    @Override
    public RoleInfo update(RoleInfo info) {
        Role role = roleRepository.findById(info.getId()).get();
        BeanUtils.copyProperties(info, role);
        return info;
    }

    @Override
    public void delete(Long id) {
        Role role = roleRepository.findById(id).get();
        if (CollectionUtils.isNotEmpty(role.getAdmins())) {
            throw new RuntimeException("不能删除有下挂用户的角色");
        }
        roleRepository.deleteById(id);
    }


    @Override
    public void deleteByIds(List<Long> ids) {
        List<Role> roleList = roleRepository.findAllById(ids);
        for (Role role : roleList) {
            if (CollectionUtils.isNotEmpty(role.getAdmins())) {
                ExceptionCast.cast(ResultCode.CANNOT_DELETE_THE_ROLE_OF_THE_LINKED_USER);
            }
        }

        roleRepository.deleteAll(roleList);
    }

    //
//	@Override
//	public String[] getRoleMenus(Long id) {
//		return StringUtils.split(roleRepository.findById(id).getMenus(), ",");
//	}
//
//	@Override
//	public void setRoleMenu(Long roleId, String menuIds) {
//		Role role = roleRepository.findById(roleId);
//		role.setMenus(menuIds);
//	}
    @Override
    public RoleInfo getInfo(Long id) {
        Role role = roleRepository.findById(id).get();
        RoleInfo info = new RoleInfo();
        BeanUtils.copyProperties(role, info);
        return info;
    }

    @Override
    public List<RoleInfo> findAll() {
        return QueryResultConverter.convert(roleRepository.findAll(), RoleInfo.class);
    }

    @Override
    public String[] getRoleResources(Long id) {
        Role role = roleRepository.findById(id).get();
        Set<String> resourceIds = new HashSet<>();
        for (RoleResource resource : role.getResources()) {
            resourceIds.add(resource.getResource().getId().toString());
        }
        return resourceIds.toArray(new String[resourceIds.size()]);
    }

    /**
     * 创建：李启云
     * 日期：2020-12-04
     * 描述：获取角色资源列表
     *
     * @param id id
     * @return {@link RoleInfo }
     */
    @Override
    public RoleInfo getRoleResourceList(Long id) {
        Role role = roleRepository.findById(id).get();
        RoleInfo roleInfo = new RoleInfo();
        Set<Long> resourceIds = new HashSet<>();
        for (RoleResource resource : role.getResources()) {
            resourceIds.add(resource.getResource().getId());
        }
        BeanUtils.copyProperties(role, roleInfo);
        roleInfo.setResourceIds(resourceIds);
        return roleInfo;
    }

    @Override
    public String[] getOrganizations(Long id) {
        Role role = roleRepository.findById(id).get();
        Set<String> organizationIds = new HashSet<>();
        for (RoleOrganization organization : role.getOrganizations()) {
            organizationIds.add(organization.getOrganization().getId().toString());
        }
        return organizationIds.toArray(new String[organizationIds.size()]);
    }


    @Override
    public void setRoleResources(Long roleId, RoleInfo roleInfo) {

        Role role = roleRepository.findById(roleId).get();
        role.setName(roleInfo.getName());
        role.setRemark(roleInfo.getRemark());
        roleResourceRepository.deleteInBatch(role.getResources());
        for (Long resourceId : roleInfo.getResourceIds()) {
            RoleResource roleResource = new RoleResource();
            roleResource.setRole(role);
            roleResource.setResource(resourceRepository.getOne(resourceId));
            roleResourceRepository.save(roleResource);
        }
    }

    @Override
    public Page<RoleInfo> page(Admin admin, RoleCondition condition, Pageable pageable) {
        Page<RoleOrganization> all = null;
        //如果登陆用户是admin 查询所有角色列表
        if (StringUtils.equals("admin", admin.getUsername())) {
            condition.setOrganizationId(null);
        }
        all = roleOrganizationRepository.findAll(new RoleSpec(condition), pageable);
        List<Role> roles = all.stream().map(RoleOrganization::getRole).collect(Collectors.toList());
        return QueryResultConverter.convert(new PageImpl<>(roles, pageable, roles.size()), RoleInfo.class, pageable);

    }

}
