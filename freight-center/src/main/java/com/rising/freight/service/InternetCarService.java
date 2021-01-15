package com.rising.freight.service;

import com.rising.common.web.base.BaseService;
import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.InternetCar;
import com.rising.freight.repository.condition.InternetCarCondition;
import com.rising.freight.dto.InternetCarDto;

/**
 * 描述：互联网汽车服务
 *
 * @see BaseService
 * 作者：李启云
 * 日期：2021-01-12
 */
public interface InternetCarService extends MeetBaseService<InternetCar, InternetCarDto, InternetCarCondition, String> {

    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：添加车和司机
     *
     * @param internetCarDto 互联网汽车dto
     * @return {@link InternetCarDto }
     */
    InternetCarDto addCarAndDriver(InternetCarDto internetCarDto);
}
