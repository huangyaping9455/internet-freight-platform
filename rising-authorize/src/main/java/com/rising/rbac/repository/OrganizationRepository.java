package com.rising.rbac.repository;

import com.rising.rbac.domain.Organization;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: UsergroupRepository
 * @date 2020/5/11 17:16
 */
@Repository
public interface OrganizationRepository extends RisingRepository<Organization> {

    Organization findByName(String groupName);

    Organization findByOldCompanyId(Long oldCompanyId);
}
