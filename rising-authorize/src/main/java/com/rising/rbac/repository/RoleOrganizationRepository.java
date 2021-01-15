package com.rising.rbac.repository;

import com.rising.rbac.domain.RoleOrganization;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: UsergroupRoleRepository
 * @date 2020/5/13 14:08
 */

@Repository
public interface RoleOrganizationRepository extends RisingRepository<RoleOrganization> {
    List<RoleOrganization> findByOrganizationId(Long id);
}
