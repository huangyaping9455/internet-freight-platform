package com.rising.freight.service;

import com.rising.common.web.base.MeetBaseService;
import com.rising.freight.domain.FinancialShippingNote;
import com.rising.freight.dto.FinancialShippingNoteDto;
import com.rising.freight.repository.condition.FinancialShippingNoteCondition;

public interface FinancialShippingNoteService extends MeetBaseService<FinancialShippingNote, FinancialShippingNoteDto, FinancialShippingNoteCondition,String> {
}
