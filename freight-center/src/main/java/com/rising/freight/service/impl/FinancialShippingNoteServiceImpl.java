package com.rising.freight.service.impl;

import com.rising.common.support.QueryResultConverter;
import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.FinancialShippingNote;
import com.rising.freight.dto.FinancialShippingNoteDto;
import com.rising.freight.repository.FinancialRepository;
import com.rising.freight.repository.FinancialShippingNoteRepository;
import com.rising.freight.repository.condition.FinancialShippingNoteCondition;
import com.rising.freight.repository.spec.FinancialShippingNoteSpec;
import com.rising.freight.service.FinancialShippingNoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class FinancialShippingNoteServiceImpl implements FinancialShippingNoteService {
   @Autowired
   private FinancialShippingNoteRepository financialShippingNoteRepository;
    @Override
    public FinancialShippingNote rConvertT(FinancialShippingNoteDto domainDto) {
        FinancialShippingNote financialShippingNote=new FinancialShippingNote();
        BeanUtils.copyProperties(domainDto,financialShippingNote);
        return financialShippingNote;
    }

    @Override
    public BaseRepository<FinancialShippingNote, String> getRepository() {
        return financialShippingNoteRepository;
    }

    @Override
    public Class<FinancialShippingNoteDto> getResponseClazz() {
        return FinancialShippingNoteDto.class;
    }

    @Override
    public Class<FinancialShippingNote> getDomainClazz() {
        return FinancialShippingNote.class;
    }

    @Override
    public Page<FinancialShippingNoteDto> findPageByCondition(FinancialShippingNoteCondition condition, Pageable pageable) {
        Page<FinancialShippingNote> financialShippingNotePage=financialShippingNoteRepository.findAll(new FinancialShippingNoteSpec(condition),pageable);
            return QueryResultConverter.convert(financialShippingNotePage,getResponseClazz(),pageable);
    }

    @Override
    public List<FinancialShippingNoteDto> findListByCondition(FinancialShippingNoteCondition condition) {
        List<FinancialShippingNote> financialShippingNoteList=financialShippingNoteRepository.findAll(new FinancialShippingNoteSpec(condition));
        return QueryResultConverter.convert(financialShippingNoteList,getResponseClazz());
    }

    @Override
    public FinancialShippingNoteDto convert(FinancialShippingNote financialShippingNote) {
        FinancialShippingNoteDto financialShippingNoteDto=new FinancialShippingNoteDto();
        BeanUtils.copyProperties(financialShippingNote,financialShippingNoteDto);
        return financialShippingNoteDto;
    }
}
