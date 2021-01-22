package com.rising.freight.service.impl;

import com.rising.common.support.QueryResultConverter;
import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.InternetDriver;
import com.rising.freight.dto.InternetDriverDto;
import com.rising.freight.repository.InternetDriverRepository;
import com.rising.freight.repository.condition.InternetDriverCondition;
import com.rising.freight.repository.spec.InternetDriverSpec;
import com.rising.freight.service.InternetDriverService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InternetDriverServiceImpl implements InternetDriverService {
    @Autowired
    private InternetDriverRepository driverRepository;

    @Override
    public BaseRepository<InternetDriver, String> getRepository() {
        return driverRepository;
    }

    @Override
    public Class<InternetDriverDto> getResponseClazz() {
        return InternetDriverDto.class;
    }

    @Override
    public Class<InternetDriver> getDomainClazz() {
        return InternetDriver.class;
    }

    @Override
    public InternetDriverDto get(String aLong) {
        return null;
    }

    @Override
    public Page<InternetDriverDto> findPageByCondition(InternetDriverCondition condition, Pageable pageable) {
        Page<InternetDriver> internetDriverPage = driverRepository.findAll(new InternetDriverSpec(condition), pageable);
        return QueryResultConverter.convert(internetDriverPage, getResponseClazz(), pageable);

    }

    @Override
    public List<InternetDriverDto> findListByCondition(InternetDriverCondition condition) {
        List<InternetDriver> internetDriverList = driverRepository.findAll(new InternetDriverSpec(condition));

        return QueryResultConverter.convert(internetDriverList, getResponseClazz());
    }

    @Override
    public InternetDriver rConvertT(InternetDriverDto domainDto) {

        InternetDriver driver = new InternetDriver();
        BeanUtils.copyProperties(domainDto, driver);
        return driver;
    }

    @Override
    public InternetDriverDto convert(InternetDriver driver) {
        InternetDriverDto driverDto = new InternetDriverDto();
        BeanUtils.copyProperties(driver, driverDto);
        return driverDto;
    }
}
