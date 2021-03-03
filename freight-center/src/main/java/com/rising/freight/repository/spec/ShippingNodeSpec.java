package com.rising.freight.repository.spec;

import com.rising.common.support.BaseSpecification;
import com.rising.common.support.DynamicQueryWrapper;
import com.rising.freight.domain.InternetShippingNode;
import com.rising.freight.repository.condition.ShippingNodeCondition;

public class ShippingNodeSpec extends BaseSpecification<InternetShippingNode, ShippingNodeCondition> {
    /**
     * @param condition 查询条件
     */
    public ShippingNodeSpec(ShippingNodeCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(DynamicQueryWrapper<InternetShippingNode> queryWrapper) {
        addLikeCondition(queryWrapper, "shippingNoteNumber");

    }
}
