/**
 *
 */
package com.rising.rbac.repository.spec;

import com.rising.rbac.domain.Organization;
import com.rising.rbac.dto.condition.OrganizationCondition;
import com.rising.rbac.repository.support.QueryWrapper;
import com.rising.rbac.repository.support.RisingSpecification;


/**
 * 描述：角色规范
 *
 * @see RisingSpecification
 * 作者：李启云
 * 日期：2020-11-24
 */
public class OrganizationSpec extends RisingSpecification<Organization, OrganizationCondition> {

    public OrganizationSpec(OrganizationCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWrapper<Organization> queryWrapper) {

        addLikeCondition(queryWrapper, "roleName");

    }

}
