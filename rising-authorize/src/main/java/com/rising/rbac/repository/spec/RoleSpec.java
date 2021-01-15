/**
 *
 */
package com.rising.rbac.repository.spec;

import com.rising.rbac.domain.RoleOrganization;
import com.rising.rbac.dto.condition.RoleCondition;
import com.rising.rbac.repository.support.QueryWrapper;
import com.rising.rbac.repository.support.RisingSpecification;


/**
 * 描述：角色规范
 *
 * @see RisingSpecification
 * 作者：李启云
 * 日期：2020-11-24
 */
public class RoleSpec extends RisingSpecification<RoleOrganization, RoleCondition> {

    public RoleSpec(RoleCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWrapper<RoleOrganization> queryWrapper) {

        addLikeCondition(queryWrapper, "name","role.name");
        addEqualsCondition(queryWrapper, "organizationId","organization.id");

    }


}