package com.rising.freight.service.impl;

import com.rising.common.support.QueryResultConverter;
import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.InternetFinancial;
import com.rising.freight.dto.FinancialDto;
import com.rising.freight.repository.FinancialRepository;
import com.rising.freight.repository.condition.FinacialCondition;
import com.rising.freight.repository.spec.FinancialSpec;
import com.rising.freight.service.FinacialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class FinacialServiceImpl implements FinacialService {
    @Autowired
    private FinancialRepository financialRepository;
    @Override
    public InternetFinancial rConvertT(FinancialDto domainDto) {
        InternetFinancial internetFinancial = new InternetFinancial();
        BeanUtils.copyProperties(domainDto, internetFinancial);
        return internetFinancial;
    }

    @Override
    public BaseRepository<InternetFinancial, String> getRepository() {
        return financialRepository;
    }

    @Override
    public Class<FinancialDto> getResponseClazz() {
        return FinancialDto.class;
    }

    @Override
    public Class<InternetFinancial> getDomainClazz() {
        return InternetFinancial.class;
    }

    @Override
    public Page<FinancialDto> findPageByCondition(FinacialCondition condition, Pageable pageable) {
        Page<InternetFinancial> financialPage = financialRepository.findAll(new FinancialSpec(condition), pageable);
        return QueryResultConverter.convert(financialPage, getResponseClazz(), pageable);
    }

    @Override
    public List<FinancialDto> findListByCondition(FinacialCondition condition) {
        List<InternetFinancial> internetFinancialList = financialRepository.findAll(new FinancialSpec(condition));
        return QueryResultConverter.convert(internetFinancialList, getResponseClazz());
    }

    @Override
    public FinancialDto convert(InternetFinancial internetFinancial) {
        FinancialDto financialDto = new FinancialDto();
        BeanUtils.copyProperties(internetFinancial, financialDto);
        return financialDto;
    }
}
