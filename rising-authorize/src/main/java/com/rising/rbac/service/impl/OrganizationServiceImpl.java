package com.rising.rbac.service.impl;

import com.rising.common.web.exception.ExceptionCast;
import com.rising.common.web.result.ResultCode;
import com.rising.rbac.controller.support.RisingBeanUtil;
import com.rising.rbac.domain.Admin;
import com.rising.rbac.domain.Organization;
import com.rising.rbac.domain.RoleOrganization;
import com.rising.rbac.dto.OrganizationInfo;
import com.rising.rbac.dto.RoleInfo;
import com.rising.rbac.repository.AdminRepository;
import com.rising.rbac.repository.OrganizationRepository;
import com.rising.rbac.repository.RoleOrganizationRepository;
import com.rising.rbac.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: OrganizationServiceImpl
 * @date 2020/5/12 14:43
 */
@Transactional
@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;


    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleOrganizationRepository roleOrganizationRepository;


    @Override
    public List<OrganizationInfo> getOrganizationList(Long adminId) throws Exception {
        Admin admin = adminRepository.findById(adminId).orElse(null);
        return organizationRepository.findByName("平台").organizationList(admin);
    }

    @Override
    public OrganizationInfo findByName(String platform) {
        Organization organization = organizationRepository.findByName(platform);
        OrganizationInfo organizationInfo = new OrganizationInfo();
        if (null == organization) return null;
        BeanUtils.copyProperties(organization, organizationInfo);
        organizationInfo.setParentId(-1L);
        return organizationInfo;
    }

    @Override
    public OrganizationInfo getInfo(Admin admin, Long organizationId) {

        Set<Long> roleIds = null;
        List<RoleOrganization> roleOrganizations = null;
        if (StringUtils.equals("admin", admin.getUsername())) {
            roleOrganizations = roleOrganizationRepository.findAll();
            List<RoleOrganization> byOrganizationId = roleOrganizationRepository.findByOrganizationId(organizationId);
            roleIds = getRoleIdsCollect(byOrganizationId);

        } else {
            roleOrganizations = roleOrganizationRepository.findByOrganizationId(organizationId);
            roleIds = getRoleIdsCollect(roleOrganizations);
        }
        Organization organization = organizationRepository.findById(organizationId).get();

        OrganizationInfo organizationInfo = new OrganizationInfo();
        BeanUtils.copyProperties(organization, organizationInfo);
        organizationInfo.setParentName(organization.getParent().getName());
        organizationInfo.setParentId(organization.getParent().getId());
        organizationInfo.setRoleList(getRoleCollect(roleOrganizations));
        organizationInfo.setRoleIds(roleIds);
        return organizationInfo;
    }

    @Override
    public OrganizationInfo getInfoByOldCompanyId(Long oldCompanyId) {
        Organization organization = organizationRepository.findByOldCompanyId(oldCompanyId);
        OrganizationInfo organizationInfo = new OrganizationInfo();
        BeanUtils.copyProperties(organization, organizationInfo);

        return organizationInfo;
    }

    private Set<RoleInfo> getRoleCollect(List<RoleOrganization> roleOrganizations) {
        return roleOrganizations.stream().map(roleOrganization -> {
            RoleInfo roleInfo = new RoleInfo();
            RisingBeanUtil.copyPropertiesIgnoreNull(roleOrganization.getRole(), roleInfo);
            return roleInfo;
        }).collect(Collectors.toSet());
    }

    private Set<Long> getRoleIdsCollect(List<RoleOrganization> roleOrganizations) {
        return roleOrganizations.stream().map(roleOrganization -> {
            return roleOrganization.getRole().getId();
        }).collect(Collectors.toSet());
    }

    @Override
    public OrganizationInfo create(OrganizationInfo info) {
        Organization parent = organizationRepository.findById(info.getParentId())
                .orElse(organizationRepository.findByName("平台"));
        Organization organization = new Organization();
        BeanUtils.copyProperties(info, organization);
        parent.addChild(organization);
        info.setId(organizationRepository.save(organization).getId());
        return info;
    }

    @Override
    public OrganizationInfo update(OrganizationInfo info) {
        Organization organization = organizationRepository.findById(info.getId()).get();
        //不拷贝属性值为null的字段
        RisingBeanUtil.copyPropertiesIgnoreNull(info, organization);
        Organization result = organizationRepository.save(organization);
        BeanUtils.copyProperties(result, info);

        return info;
    }

    @Override
    public void delete(Long id) {
        Organization organization = organizationRepository.findById(id).get();
        if (!CollectionUtils.isEmpty(organization.getChilds()))
            ExceptionCast.cast(ResultCode.CANNOT_DELETE_COMPANIES_WITH_DEPARTMENTS);
        organizationRepository.deleteById(id);

    }

    @Override
    public Long move(Long id, boolean up) {
        Organization organization = organizationRepository.findById(id).get();
        int index = organization.getSort();
        List<Organization> childs = organization.getParent().getChilds();
        for (int i = 0; i < childs.size(); i++) {
            Organization current = childs.get(i);
            if (current.getId().equals(id)) {
                if (up) {
                    if (i != 0) {
                        Organization pre = childs.get(i - 1);
                        organization.setSort(pre.getSort());
                        pre.setSort(index);
                        organizationRepository.save(pre);
                    }
                } else {
                    if (i != childs.size() - 1) {
                        Organization next = childs.get(i + 1);
                        organization.setSort(next.getSort());
                        next.setSort(index);
                        organizationRepository.save(next);
                    }
                }
            }
        }
        organizationRepository.save(organization);
        return organization.getParent().getId();
    }


}
