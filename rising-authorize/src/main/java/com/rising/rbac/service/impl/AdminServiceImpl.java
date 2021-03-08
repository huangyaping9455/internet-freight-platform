/**
 *
 */
package com.rising.rbac.service.impl;

import com.rising.common.web.exception.ExceptionCast;
import com.rising.common.web.result.ResultCode;
import com.rising.rbac.controller.support.QueryResultConverter;
import com.rising.rbac.domain.Admin;
import com.rising.rbac.domain.Organization;
import com.rising.rbac.domain.Role;
import com.rising.rbac.domain.RoleAdmin;
import com.rising.rbac.dto.AdminInfo;
import com.rising.rbac.dto.condition.AdminCondition;
import com.rising.rbac.repository.AdminRepository;
import com.rising.rbac.repository.OrganizationRepository;
import com.rising.rbac.repository.RoleAdminRepository;
import com.rising.rbac.repository.RoleRepository;
import com.rising.rbac.repository.spec.AdminSpec;
import com.rising.rbac.service.IAdminService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleAdminRepository roleAdminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private OrganizationRepository organizationRepository;

    /**
     * 方法描述：创建
     * 创建时间：2020-07-01
     * 创建作者：李齐云
     *
     * @param adminInfo 管理信息
     */
    @Override
    public AdminInfo create(AdminInfo adminInfo) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminInfo, admin);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        adminInfo.setId(admin.getId());
        if (CollectionUtils.isNotEmpty(adminInfo.getRoleIdList())) {
            createRolesAdmin(adminInfo, admin);
        }
        if (adminInfo.getOrganizationId() != null) {
            createOrganizationAdmin(adminInfo, admin);
        }
        return adminInfo;
    }

    /**
     * @see IAdminService#update(AdminInfo)
     */
    @Override
    public AdminInfo update(AdminInfo adminInfo) {

        Admin admin = adminRepository.findById(adminInfo.getId()).get();
        BeanUtils.copyProperties(adminInfo, admin);

        createRolesAdmin(adminInfo, admin);

        return adminInfo;
    }


    private void createRoleAdmin(AdminInfo adminInfo, Admin admin) {
        if (CollectionUtils.isNotEmpty(admin.getRoles())) {
            roleAdminRepository.deleteInBatch(admin.getRoles());
        }
        RoleAdmin roleAdmin = new RoleAdmin();
        roleAdmin.setRole(roleRepository.getOne(adminInfo.getRoleIdList().get(0)));
        roleAdmin.setAdmin(admin);
        roleAdminRepository.save(roleAdmin);
    }


    private void createRolesAdmin(AdminInfo adminInfo, Admin admin) {
        if (CollectionUtils.isNotEmpty(admin.getRoles())) {
            roleAdminRepository.deleteInBatch(admin.getRoles());
        }
        Set<RoleAdmin> roleAdminList = new HashSet<>();
        List<Role> roleList = roleRepository.findAllById(adminInfo.getRoleIdList());
        for (Role role : roleList) {
            RoleAdmin roleAdmin = new RoleAdmin();
            roleAdmin.setRole(role);
            roleAdmin.setAdmin(admin);
            roleAdminList.add(roleAdmin);
        }
        roleAdminRepository.saveAll(roleAdminList);
    }


    private void createOrganizationAdmin(AdminInfo adminInfo, Admin admin) {
        Organization organization = organizationRepository.findById(adminInfo.getOrganizationId()).orElse(new Organization());
        admin.setOrganization(organization);
        adminRepository.save(admin);


    }


    /**
     * (non-Javadoc)
     *
     * @see IAdminService#delete(java.lang.Long)
     */
    @Override
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }

    /**
     * (non-Javadoc)
     *
     * @see IAdminService#getInfo(java.lang.Long)
     */
    @Override
    public AdminInfo getInfo(Long id) {
        Admin admin = adminRepository.findById(id).orElse(new Admin());
        AdminInfo info = new AdminInfo();
        info.setRoleIdList(admin.getRoles().stream().map(item -> item.getRole().getId()).collect(Collectors.toList()));
        BeanUtils.copyProperties(admin, info);
        return info;
    }


    @Override
    public Page<AdminInfo> query(String username, AdminCondition condition, Pageable pageable) {
        if (StringUtils.equals("admin", username)) {
            condition.setOrganizationId(null);
        }
        Page<Admin> admins = adminRepository.findAll(new AdminSpec(condition), pageable);
        return QueryResultConverter.convert(admins, AdminInfo.class, pageable);
    }


    @Override
    public Page<AdminInfo> query(AdminCondition condition, Pageable pageable) {
        Page<Admin> admins = adminRepository.findAll(new AdminSpec(condition), pageable);
        return QueryResultConverter.convert(admins, AdminInfo.class, pageable);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        List<Admin> admins = adminRepository.findAllById(ids);
        adminRepository.deleteAll(admins);


    }

    @Override
    public Admin findByUsername(String username) {

        return adminRepository.findByUsername(username);
    }

    @Override
    public boolean updatePassword(Long id, String oldPassword, String newPassword) {
        Admin admin = adminRepository.findById(id).get();
        boolean matches = passwordEncoder.matches(oldPassword,admin.getPassword());
        if (!matches)
            ExceptionCast.cast(ResultCode.LOGIN_ORIGINAL_PASSWORD_NOT_MATCH);
        admin.setPassword(passwordEncoder.encode(newPassword));
        adminRepository.save(admin);
        return true;
    }

}
