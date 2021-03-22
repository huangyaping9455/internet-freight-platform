package com.rising.freight.controller;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.common.web.base.BaseController;
import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.InternetCar;
import com.rising.freight.dto.InternetCarDto;
import com.rising.freight.repository.condition.InternetCarCondition;
import com.rising.freight.service.InternetCarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 版本：1.0.0
 * 描述：车辆管理
 *
 * @see BaseController
 * 码农：李齐云
 * 日期：2021-03-22
 */
@RestController
@RequestMapping("internetCars")
public class InternetCarController extends BaseController<InternetCar, InternetCarDto, InternetCarCondition, String> {
    @Autowired
    private InternetCarService internetCarService;

    @Override
    public MeetBaseService<InternetCar, InternetCarDto, InternetCarCondition, String> getService() {
        return internetCarService;
    }


    @ResponseResult
    @ApiOperation(value = "根据条件查询车辆信息")
    @GetMapping("/getCarByCondition")
    public InternetCarDto getCarByCondition(InternetCarCondition carCondition) {
        return internetCarService.findCarByCondition(carCondition);

    }
}
