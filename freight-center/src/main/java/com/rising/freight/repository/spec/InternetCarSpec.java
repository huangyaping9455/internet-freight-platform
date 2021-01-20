package com.rising.freight.repository.spec;

import com.rising.common.support.BaseSpecification;
import com.rising.common.support.DynamicQueryWrapper;
import com.rising.freight.domain.InternetCar;
import com.rising.freight.repository.condition.InternetCarCondition;

public class InternetCarSpec extends BaseSpecification<InternetCar, InternetCarCondition> {
    /**
     * @param condition 查询条件
     */
    public InternetCarSpec(InternetCarCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(DynamicQueryWrapper<InternetCar> queryWrapper) {
        addLikeCondition(queryWrapper, "vehicleNumber");
        addLikeCondition(queryWrapper, "owner");

    }
}
