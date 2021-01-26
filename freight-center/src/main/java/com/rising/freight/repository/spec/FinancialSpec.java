package com.rising.freight.repository.spec;

import com.rising.common.support.BaseSpecification;
import com.rising.common.support.DynamicQueryWrapper;
import com.rising.freight.domain.Financial;
import com.rising.freight.repository.condition.FinacialCondition;

public class FinancialSpec extends BaseSpecification<Financial, FinacialCondition> {
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
    protected void addCondition(DynamicQueryWrapper<Financial> queryWrapper) {
        addLikeCondition(queryWrapper, "documentNumber");
    }
}
