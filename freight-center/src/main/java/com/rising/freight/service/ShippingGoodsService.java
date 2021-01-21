package com.rising.freight.service;

import com.rising.common.web.base.BaseService;
import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.ShippingGoods;
import com.rising.freight.dto.InternetCarDto;
import com.rising.freight.dto.ShippingGoodsDto;
import com.rising.freight.repository.condition.ShippingGoodsCondition;

/**
 * 描述：互联网汽车服务
 *
 * @see BaseService
 * 作者：李启云
 * 日期：2021-01-12
 */
public interface ShippingGoodsService extends MeetBaseService<ShippingGoods, ShippingGoodsDto, ShippingGoodsCondition, String> {


    /**
     * 创建：李启云
     * 日期：2021-01-15
     * 描述：根据条件获取车辆信息
     *
     * @param carCondition 车条件
     * @return {@link InternetCarDto }
     */
    ShippingGoodsDto findGoodsByCondition(ShippingGoodsCondition carCondition);

}
