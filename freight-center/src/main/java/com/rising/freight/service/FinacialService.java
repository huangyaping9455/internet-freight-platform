package com.rising.freight.service;

import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.Financial;
import com.rising.freight.domain.InternetDriver;
import com.rising.freight.dto.FinancialDto;
import com.rising.freight.dto.InternetDriverDto;
import com.rising.freight.repository.condition.FinacialCondition;
import com.rising.freight.repository.condition.InternetDriverCondition;

public interface FinacialService extends MeetBaseService<Financial, FinancialDto, FinacialCondition,String> {

}
