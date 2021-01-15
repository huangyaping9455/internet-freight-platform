package com.rising.freight.service.impl;

import com.rising.common.support.QueryResultConverter;
import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.InternetCar;
import com.rising.freight.dto.InternetCarDto;
import com.rising.freight.repository.InternetCarRepository;
import com.rising.freight.repository.condition.InternetCarCondition;
import com.rising.freight.repository.spec.InternetCarSpec;
import com.rising.freight.service.InternetCarService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class InternetCarServiceImpl implements InternetCarService {


    @Autowired
    private InternetCarRepository internetCarRepository;


    @Override
    public BaseRepository<InternetCar, String> getRepository() {
        return internetCarRepository;
    }

    @Override
    public Class<InternetCarDto> getResponseClazz() {
        return InternetCarDto.class;
    }

    @Override
    public Class<InternetCar> getDomainClazz() {
        return InternetCar.class;
    }


    @Override
    public InternetCarDto convert(InternetCar car) {
        InternetCarDto internetCarDto = new InternetCarDto();
        BeanUtils.copyProperties(car, internetCarDto);
        return internetCarDto;
    }

    @Override
    public InternetCar rConvertT(InternetCarDto domain) {
        InternetCar internetCar = new InternetCar();
        BeanUtils.copyProperties(domain, internetCar);
        return internetCar;
    }

    @Override
    public Page<InternetCarDto> findPageByCondition(InternetCarCondition condition, Pageable pageable) {

        Page<InternetCar> internetCarPage = internetCarRepository.findAll(new InternetCarSpec(condition), pageable);
        return QueryResultConverter.convert(internetCarPage, getResponseClazz(), pageable);
    }

    @Override
    public List<InternetCarDto> findListByCondition(InternetCarCondition condition) {
        List<InternetCar> internetCarList = internetCarRepository.findAll(new InternetCarSpec(condition));
        return QueryResultConverter.convert(internetCarList, getResponseClazz());
    }


    @Override
    public InternetCarDto addCarAndDriver(InternetCarDto internetCarDto) {
        InternetCar internetCar = new InternetCar();
        BeanUtils.copyProperties(internetCarDto, internetCar);

        if (CollectionUtils.isNotEmpty(internetCarDto.getDrivers())) {


        }
        internetCarRepository.save(internetCar);
        return internetCarDto;
    }


}
