package com.rising.freight.service.impl;

import com.rising.common.support.QueryResultConverter;
import com.rising.common.web.base.BaseRepository;
import com.rising.freight.domain.ShippingNode;
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
    public BaseRepository<ShippingNode, String> getRepository() {
        return shippingNodeRepository;
    }

    @Override
    public Class<ShippingNodeDto> getResponseClazz() {
        return ShippingNodeDto.class;
    }

    @Override
    public Class<ShippingNode> getDomainClazz() {
        return ShippingNode.class;
    }

    @Override
    public Page<ShippingNodeDto> findPageByCondition(ShippingNodeCondition condition, Pageable pageable) {
        return null;
    }


    @Override
    public ShippingNodeDto convert(ShippingNode shippingNode) {
        ShippingNodeDto shippingNodeDto = new ShippingNodeDto();
        BeanUtils.copyProperties(shippingNodeDto, shippingNode);
        return shippingNodeDto;
    }

    @Override
    public ShippingNode rConvertT(ShippingNodeDto domain) {
        ShippingNode shippingNode = new ShippingNode();
        BeanUtils.copyProperties(domain, shippingNode);
        return shippingNode;
    }



    @Override
    public List<ShippingNodeDto> findListByCondition(ShippingNodeCondition condition) {
        List<ShippingNode> shippingNodeList = shippingNodeRepository.findAll(new ShippingNodeSpec(condition));
        return QueryResultConverter.convert(shippingNodeList, getResponseClazz());
    }



    @Override
    public ShippingNodeDto findShippingNodeByCondition(ShippingNodeCondition condition) {
        ShippingNode shippingNode = shippingNodeRepository.findOne(new ShippingNodeSpec(condition)).orElse(new ShippingNode());
        ShippingNodeDto shippingNodeDto = new ShippingNodeDto();
        BeanUtils.copyProperties(shippingNode, shippingNodeDto);
        return shippingNodeDto;
    }


}
