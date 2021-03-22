package com.rising.freight.controller;

import com.rising.common.web.base.BaseController;
import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.InternetFinancial;
import com.rising.freight.dto.FinancialDto;
import com.rising.freight.repository.condition.FinacialCondition;
import com.rising.freight.service.FinacialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版本：1.0.0
 * 描述：财务管理
 *
 * @see BaseController
 * 码农：李齐云
 * 日期：2021-03-22
 */
@RestController
@RequestMapping("/financials")
public class FinancialController extends BaseController<InternetFinancial, FinancialDto, FinacialCondition,String> {

    @Autowired
    private FinacialService finacialService;
    @Override
    public MeetBaseService<InternetFinancial, FinancialDto, FinacialCondition, String> getService() {
        return finacialService;
    }



}
