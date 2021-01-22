package com.rising.freight.service.impl;

import com.rising.common.support.QueryResultConverter;
import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.Financial;
import com.rising.freight.domain.InternetDriver;
import com.rising.freight.dto.FinancialDto;
import com.rising.freight.dto.InternetDriverDto;
import com.rising.freight.repository.FinancialRepository;
import com.rising.freight.repository.condition.FinacialCondition;
import com.rising.freight.repository.spec.FinancialSpec;
import com.rising.freight.repository.spec.InternetDriverSpec;
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
    public Financial rConvertT(FinancialDto domainDto) {
        Financial financial = new Financial();
        BeanUtils.copyProperties(domainDto, financial);
        return financial;
    }

    @Override
    public BaseRepository<Financial, String> getRepository() {
        return financialRepository;
    }

    @Override
    public Class<FinancialDto> getResponseClazz() {
        return FinancialDto.class;
    }

    @Override
    public Class<Financial> getDomainClazz() {
        return Financial.class;
    }

    @Override
    public Page<FinancialDto> findPageByCondition(FinacialCondition condition, Pageable pageable) {
        Page<Financial> financialPage = financialRepository.findAll(new FinancialSpec(condition), pageable);
        return QueryResultConverter.convert(financialPage, getResponseClazz(), pageable);
    }

    @Override
    public List<FinancialDto> findListByCondition(FinacialCondition condition) {
        List<Financial> financialList = financialRepository.findAll(new FinancialSpec(condition));

        return QueryResultConverter.convert(financialList, getResponseClazz());
    }

    @Override
    public FinancialDto convert(Financial financial) {
        FinancialDto financialDto = new FinancialDto();
        BeanUtils.copyProperties(financial, financialDto);
        return financialDto;
    }
}
