package com.rising.freight.controller;

import com.rising.common.web.base.BaseController;
import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.Financial;
import com.rising.freight.domain.FinancialShippingNote;
import com.rising.freight.dto.FinancialDto;
import com.rising.freight.dto.FinancialShippingNoteDto;
import com.rising.freight.repository.condition.FinacialCondition;
import com.rising.freight.repository.condition.FinancialShippingNoteCondition;
import com.rising.freight.service.FinacialService;
import com.rising.freight.service.FinancialShippingNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financials")
public class FinancialController extends BaseController<Financial, FinancialDto, FinacialCondition,String> {

    @Autowired
    private FinacialService finacialService;

    @Override
    public MeetBaseService<Financial, FinancialDto, FinacialCondition, String> getService() {
        return finacialService;
    }



}
