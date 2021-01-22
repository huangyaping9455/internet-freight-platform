package com.rising.freight.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rising.freight.dto.SendMessageDto;

import com.rising.freight.repository.InternetCarRepository;
import com.rising.freight.repository.InternetDriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Slf4j
@Service
@Transactional
public class FreightCenterMessageService {

    @Autowired
    private InternetCarRepository carRepository;

    @Autowired
    private InternetDriverRepository driverRepository;

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
                            value = @Queue(name = "uaa.organization.queue"),
                            exchange = @Exchange(name = "exchange.wlt.uaa", type = ExchangeTypes.TOPIC),
                            key = "key.uaa.organization"
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
        switch (messageDto.getMessageTypeEnum()) {
            case CAR:
                log.info("开始保存>>>>>车辆信息:{}", messageDto);

                break;
            case DRIVER:
                log.info("开始保存>>>>>>司机信息:{}", messageDto);
                break;
            case SHIPPING_NODE:
                log.info("开始保存>>>>>运单信息:{}", messageDto);
                break;
            case FINANCIAL:
                log.info("开始保存>>>>>资金流水信息:{}", messageDto);

                break;
        }

    }


}
