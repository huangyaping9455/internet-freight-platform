package com.rising.freight.repository.spec;

import com.rising.common.support.BaseSpecification;
import com.rising.common.support.DynamicQueryWrapper;
import com.rising.freight.domain.ShippingGoods;
import com.rising.freight.repository.condition.ShippingGoodsCondition;

public class ShippingGoodsSpec extends BaseSpecification<ShippingGoods, ShippingGoodsCondition> {
    /**
     * @param condition 查询条件
     */
    public ShippingGoodsSpec(ShippingGoodsCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(DynamicQueryWrapper<ShippingGoods> queryWrapper) {
        addLikeCondition(queryWrapper, "vehicleNumber");
        addLikeCondition(queryWrapper, "owner");

    }
}
