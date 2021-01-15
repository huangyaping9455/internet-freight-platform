/**
 *
 */
package com.rising.rbac.repository.spec;

import com.rising.rbac.domain.Admin;
import com.rising.rbac.dto.condition.AdminCondition;
import com.rising.rbac.repository.support.QueryWrapper;
import com.rising.rbac.repository.support.RisingSpecification;


/**
 * 描述：管理规范
 *
 * @see RisingSpecification
 * 作者：李启云
 * 日期：2020-12-03
 */
public class AdminSpec extends RisingSpecification<Admin, AdminCondition> {

    public AdminSpec(AdminCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWrapper<Admin> queryWrapper) {

        addLikeCondition(queryWrapper, "username");
        addEqualsCondition(queryWrapper, "organizationId","organization.id");

    }

}
