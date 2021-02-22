package com.rising.freight.service.mq;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rising.common.clients.RisingServiceList;
import com.rising.freight.client.OrganizationInfo;
import com.rising.freight.domain.InternetCar;
import com.rising.freight.domain.InternetDriver;
import com.rising.freight.dto.InternetCarDto;
import com.rising.freight.dto.SendMessageDto;

import com.rising.freight.repository.InternetCarRepository;
import com.rising.freight.repository.InternetDriverRepository;
import com.rising.freight.repository.condition.InternetCarCondition;
import com.rising.freight.service.InternetCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;

@Slf4j
@Service
@Transactional
public class FreightCenterMessageService {

    @Autowired
    private InternetCarService carService;

    @Autowired
    private InternetDriverRepository driverRepository;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;


    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 创建：李启云
     * 日期：2021-01-21
     * 描述：处理消息
     * 监听队列消息并处理
     *
     * @param message 消息
     * @return
     * @throws IOException ioexception
     */
    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            value = @Queue(name = "freightCenter.car.queue",
                                    arguments = {
                                            //   @Argument(name =
                                            //   "x-message-ttl", value =
                                            //   "1000", type = "java.lang
                                            //   .Integer"),
                                            //   @Argument(name =
                                            //   "x-dead-letter-exchange",
                                            //   value = "aaaaa"),
                                            //   @Argument(name =
                                            //   "x-dead-letter-routing-key", value = "bbbb")
                                    }),
                            exchange = @Exchange(name = "exchange..wlt.freightCenter", type = ExchangeTypes.TOPIC),
                            key = "key.freightCenter.car"
                    ),
                    @QueueBinding(
                            value = @Queue(name = "freightCenter.driver.queue"),
                            exchange = @Exchange(name = "exchange..wlt.freightCenter", type = ExchangeTypes.TOPIC),
                            key = "key.freightCenter.driver"
                    ),
                    @QueueBinding(
                            value = @Queue(name = "freightCenter.financial.queue"),
                            exchange = @Exchange(name = "exchange.wlt.freightCenter", type = ExchangeTypes.TOPIC),
                            key = "key.freightCenter.financial"
                    ),
                    @QueueBinding(
                            value = @Queue(name = "freightCenter.shippingNode.queue"),
                            exchange = @Exchange(name = "exchange.wlt.freightCenter", type = ExchangeTypes.TOPIC),
                            key = "key.freightCenter.shippingNode"
                    ),

                    @QueueBinding(
                            value = @Queue(name = "freightCenter.organization.queue"),
                            exchange = @Exchange(name = "exchange.uaa.freightCenter", type = ExchangeTypes.TOPIC),
                            key = "key.uaa.organization"
                    )
            }
    )
    public void handleMessage(@Payload Message message) throws IOException {

        SendMessageDto messageDto = objectMapper.readValue(message.getBody(), SendMessageDto.class);
        ServiceInstance choose = loadBalancerClient.choose(RisingServiceList.UAA);
        URI uri = choose.getUri();
        String path = choose.getUri() + "/sys/organization/getInfoByOldCompanyId/" + messageDto.getOldCompanyId();

        OrganizationInfo organizationInfo = restTemplate.getForObject(path, OrganizationInfo.class);

        switch (messageDto.getMessageTypeEnum()) {
            case CAR:
                log.info("开始保存>>>>>车辆信息:{}", messageDto);
                messageDto.setOrganizationId(organizationInfo.getId().toString());
                InternetCarDto carDto = new InternetCarDto();
                BeanUtils.copyProperties(messageDto, carDto);
                carDto.setIssueDate(LocalDate.parse(messageDto.getIssueDate()));
                InternetCarCondition carCondition = new InternetCarCondition();
                carCondition.setOrganizationId(organizationInfo.getId());
                carCondition.setIsDelete(false);
              //  InternetCarDto carByCondition = carService.findCarByCondition(carCondition);
              //  carService.save(carDto);
                break;
            case DRIVER:
                log.info("开始保存>>>>>>司机信息:{}", messageDto);
                InternetDriver driver = new InternetDriver();
                BeanUtils.copyProperties(messageDto, driver);
                driver.setValidPeriodFrom(LocalDate.parse(messageDto.getValidPeriodFrom()));
                driver.setValidPeriodTo(LocalDate.parse(messageDto.getValidPeriodTo()));
                driverRepository.save(driver);
                break;
            case SHIPPING_NODE:
                log.info("开始保存>>>>>运单信息:{}", messageDto);
                break;
            case FINANCIAL:
                log.info("开始保存>>>>>资金流水信息:{}", messageDto);

                break;
        }


    }

    public static void main(String[] args) {

    }

}
