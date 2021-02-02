package com.rising.messagehandle;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rising.rbac.dto.OrganizationInfo;
import com.rising.rbac.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

@Slf4j
@Service
public class UAAMessageService {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

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
                            value = @Queue(name = "uaa.organization.queue"),
                            exchange = @Exchange(name = "exchange.wlt.uaa", type = ExchangeTypes.TOPIC),
                            key = "key.uaa.organization"
                    )
            }
    )
    public void handleMessage(@Payload Message message) throws IOException {
        log.info("AuthorizeMessageService开始处理消息>>>>{}", new String(message.getBody()));
        OrganizationInfo organizationInfo = objectMapper.readValue(message.getBody(), OrganizationInfo.class);
        OrganizationInfo result = organizationService.findByName(organizationInfo.getName());
        if (ObjectUtils.isEmpty(result)) {
            result = organizationService.create(organizationInfo);
        }
        log.info("AuthorizeMessageService处理结果>>>>{}", result);

    }


}
