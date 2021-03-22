package com.rising.freight.controller;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.common.web.base.BaseController;
import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.InternetShippingNode;
import com.rising.freight.dto.ShippingNodeDto;
import com.rising.freight.repository.condition.ShippingNodeCondition;
import com.rising.freight.service.ShippingNodeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版本：1.0.0
 * 描述：运单管理
 *
 * @see BaseController
 * 码农：李齐云
 * 日期：2021-03-22
 */
@RestController
@RequestMapping("internetOrders")
public class ShippingNodeController extends BaseController<InternetShippingNode, ShippingNodeDto, ShippingNodeCondition, String> {
    @Autowired
    private ShippingNodeService shippingNodeService;

    @Override
    public MeetBaseService<InternetShippingNode, ShippingNodeDto, ShippingNodeCondition, String> getService() {
        return shippingNodeService;
    }


    @ResponseResult
    @ApiOperation(value = "根据条件查询订单信息")
    @GetMapping("/getOrdersByCondition")
    public ShippingNodeDto getOrdersByCondition(ShippingNodeCondition ordersCondition) {
        return shippingNodeService.findShippingNodeByCondition(ordersCondition);

    }
}
