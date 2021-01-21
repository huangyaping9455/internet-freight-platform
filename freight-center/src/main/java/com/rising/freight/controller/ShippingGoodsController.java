package com.rising.freight.controller;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.common.web.base.BaseController;
import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.ShippingGoods;
import com.rising.freight.dto.ShippingGoodsDto;
import com.rising.freight.repository.condition.ShippingGoodsCondition;
import com.rising.freight.service.ShippingGoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("internetGoods")
public class ShippingGoodsController extends BaseController<ShippingGoods, ShippingGoodsDto, ShippingGoodsCondition, String> {
    @Autowired
    private ShippingGoodsService shippingGoodsService;

    @Override
    public MeetBaseService<ShippingGoods, ShippingGoodsDto, ShippingGoodsCondition, String> getService() {
        return shippingGoodsService;
    }


    @ResponseResult
    @ApiOperation(value = "根据条件查询货物信息")
    @GetMapping("/getGoodsByCondition")
    public ShippingGoodsDto getGoodsByCondition(ShippingGoodsCondition goodsCondition) {
        return shippingGoodsService.findGoodsByCondition(goodsCondition);

    }
}
