package com.rising.freight.repository.spec;

import com.rising.common.support.BaseSpecification;
import com.rising.common.support.DynamicQueryWrapper;
import com.rising.freight.domain.InternetFinancial;
import com.rising.freight.repository.condition.FinacialCondition;

public class FinancialSpec extends BaseSpecification<InternetFinancial, FinacialCondition> {
    /**
     * 创建：曾庆玲
     * 日期：2021-01-21
     * 描述：基础规范
     *
     * @param condition 条件
     * @return {@link  }
     */
    public FinancialSpec(FinacialCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(DynamicQueryWrapper<InternetFinancial> queryWrapper) {
        addLikeCondition(queryWrapper, "documentNumber");
        addEqualsCondition(queryWrapper, "carrier");
        addEqualsCondition(queryWrapper, "vehicleNumber");
        addEqualsCondition(queryWrapper, "isDelete");
        addEqualsCondition(queryWrapper, "organizationId");
    }
}
