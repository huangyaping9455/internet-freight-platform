package com.rising.freight.service.impl;

import com.rising.common.support.QueryResultConverter;
import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.InternetShippingNode;
import com.rising.freight.dto.ShippingNodeDto;
import com.rising.freight.repository.ShippingNodeRepository;
import com.rising.freight.repository.condition.ShippingNodeCondition;
import com.rising.freight.repository.spec.ShippingNodeSpec;
import com.rising.freight.service.ShippingNodeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ShippingNodeServiceImpl implements ShippingNodeService {


    @Autowired
    private ShippingNodeRepository shippingNodeRepository;


    @Override
    public BaseRepository<InternetShippingNode, String> getRepository() {
        return shippingNodeRepository;
    }

    @Override
    public Class<ShippingNodeDto> getResponseClazz() {
        return ShippingNodeDto.class;
    }

    @Override
    public Class<InternetShippingNode> getDomainClazz() {
        return InternetShippingNode.class;
    }

    @Override
    public Page<ShippingNodeDto> findPageByCondition(ShippingNodeCondition condition, Pageable pageable) {
        return null;
    }


    @Override
    public ShippingNodeDto convert(InternetShippingNode internetShippingNode) {
        ShippingNodeDto shippingNodeDto = new ShippingNodeDto();
        BeanUtils.copyProperties(shippingNodeDto, internetShippingNode);
        return shippingNodeDto;
    }

    @Override
    public InternetShippingNode rConvertT(ShippingNodeDto domain) {
        InternetShippingNode internetShippingNode = new InternetShippingNode();
        BeanUtils.copyProperties(domain, internetShippingNode);
        return internetShippingNode;
    }



    @Override
    public List<ShippingNodeDto> findListByCondition(ShippingNodeCondition condition) {
        List<InternetShippingNode> internetShippingNodeList = shippingNodeRepository.findAll(new ShippingNodeSpec(condition));
        return QueryResultConverter.convert(internetShippingNodeList, getResponseClazz());
    }



    @Override
    public ShippingNodeDto findShippingNodeByCondition(ShippingNodeCondition condition) {
        InternetShippingNode internetShippingNode = shippingNodeRepository.findOne(new ShippingNodeSpec(condition)).orElse(new InternetShippingNode());
        ShippingNodeDto shippingNodeDto = new ShippingNodeDto();
        BeanUtils.copyProperties(internetShippingNode, shippingNodeDto);
        return shippingNodeDto;
    }


}
