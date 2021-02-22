package com.rising.freight.repository.spec;

import com.rising.common.support.BaseSpecification;
import com.rising.common.support.DynamicQueryWrapper;
import com.rising.freight.domain.InternetDriver;
import com.rising.freight.repository.condition.InternetDriverCondition;

public class InternetDriverSpec extends BaseSpecification<InternetDriver, InternetDriverCondition> {
    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：基础规范
     *
     * @param condition 条件
     * @return {@link  }
     */
    public InternetDriverSpec(InternetDriverCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(DynamicQueryWrapper<InternetDriver> queryWrapper) {
        addLikeCondition(queryWrapper, "driverName");
        addLikeCondition(queryWrapper, "telephone");
    }
}
