package com.rising.freight.service.impl;

import com.rising.common.support.QueryResultConverter;
import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.ShippingGoods;
import com.rising.freight.dto.ShippingGoodsDto;
import com.rising.freight.repository.ShippingGoodsRepository;
import com.rising.freight.repository.condition.ShippingGoodsCondition;
import com.rising.freight.repository.spec.ShippingGoodsSpec;
import com.rising.freight.service.ShippingGoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ShippingGoodsServiceImpl implements ShippingGoodsService {


    @Autowired
    private ShippingGoodsRepository shippingGoodsRepository;


    @Override
    public BaseRepository<ShippingGoods, String> getRepository() {
        return shippingGoodsRepository;
    }

    @Override
    public Class<ShippingGoodsDto> getResponseClazz() {
        return ShippingGoodsDto.class;
    }

    @Override
    public Class<ShippingGoods> getDomainClazz() {
        return ShippingGoods.class;
    }


    @Override
    public ShippingGoodsDto convert(ShippingGoods car) {
        ShippingGoodsDto shippingGoodsDto = new ShippingGoodsDto();
        BeanUtils.copyProperties(car, shippingGoodsDto);
        return shippingGoodsDto;
    }

    @Override
    public ShippingGoods rConvertT(ShippingGoodsDto domain) {
        ShippingGoods shippingGoods = new ShippingGoods();
        BeanUtils.copyProperties(domain, shippingGoods);
        return shippingGoods;
    }

    @Override
    public Page<ShippingGoodsDto> findPageByCondition(ShippingGoodsCondition condition, Pageable pageable) {

        Page<ShippingGoods> shippingGoodsPage = shippingGoodsRepository.findAll(new ShippingGoodsSpec(condition), pageable);
        return QueryResultConverter.convert(shippingGoodsPage, getResponseClazz(), pageable);
    }

    @Override
    public List<ShippingGoodsDto> findListByCondition(ShippingGoodsCondition condition) {
        List<ShippingGoods> shippingGoodsList = shippingGoodsRepository.findAll(new ShippingGoodsSpec(condition));
        return QueryResultConverter.convert(shippingGoodsList, getResponseClazz());
    }




    @Override
    public ShippingGoodsDto findGoodsByCondition(ShippingGoodsCondition condition) {
        ShippingGoods shippingGoods = shippingGoodsRepository.findOne(new ShippingGoodsSpec(condition)).orElse(new ShippingGoods());
        ShippingGoodsDto shippingGoodsDto = new ShippingGoodsDto();
        BeanUtils.copyProperties(shippingGoods, shippingGoodsDto);
        return shippingGoodsDto;
    }


}
