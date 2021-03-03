package com.rising.freight.repository.spec;

import com.rising.common.support.BaseSpecification;
import com.rising.common.support.DynamicQueryWrapper;
import com.rising.freight.domain.FinancialShippingNote;
import com.rising.freight.repository.condition.FinancialShippingNoteCondition;

public class FinancialShippingNoteSpec extends BaseSpecification<FinancialShippingNote, FinancialShippingNoteCondition> {
    /**
     * 创建：曾庆玲
     * 日期：2021-01-21
     * 描述：基础规范
     *
     * @param condition 条件
     * @return {@link  }
     */
    public FinancialShippingNoteSpec(FinancialShippingNoteCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(DynamicQueryWrapper<FinancialShippingNote> queryWrapper) {
        addLikeCondition(queryWrapper,"shippingNoteNumber");
    }
}
