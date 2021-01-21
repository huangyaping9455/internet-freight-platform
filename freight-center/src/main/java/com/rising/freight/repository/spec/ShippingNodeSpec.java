package com.rising.freight.repository.spec;

import com.rising.common.support.BaseSpecification;
import com.rising.common.support.DynamicQueryWrapper;
import com.rising.freight.domain.ShippingNode;
import com.rising.freight.repository.condition.ShippingNodeCondition;

public class ShippingNodeSpec extends BaseSpecification<ShippingNode, ShippingNodeCondition> {
    /**
     * @param condition 查询条件
     */
    public ShippingNodeSpec(ShippingNodeCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(DynamicQueryWrapper<ShippingNode> queryWrapper) {
        addLikeCondition(queryWrapper, "vehicleNumber");
        addLikeCondition(queryWrapper, "owner");

    }
}
