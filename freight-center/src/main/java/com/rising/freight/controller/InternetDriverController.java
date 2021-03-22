package com.rising.freight.controller;

import com.rising.common.web.base.BaseController;
import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.InternetDriver;
import com.rising.freight.dto.InternetDriverDto;
import com.rising.freight.repository.condition.InternetDriverCondition;
import com.rising.freight.service.InternetDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版本：1.0.0
 * 描述：司机管理
 *
 * @see BaseController
 * 码农：李齐云
 * 日期：2021-03-22
 */
@RestController
@RequestMapping("/internetDrivers")
public class InternetDriverController extends BaseController<InternetDriver, InternetDriverDto, InternetDriverCondition,String> {

    @Autowired
    private InternetDriverService driverService;
    @Override
    public MeetBaseService<InternetDriver, InternetDriverDto, InternetDriverCondition, String> getService() {
        return driverService;
    }



}
