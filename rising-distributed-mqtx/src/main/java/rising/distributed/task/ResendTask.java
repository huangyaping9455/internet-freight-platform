package rising.distributed.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import rising.distributed.po.TransMessage;
import rising.distributed.service.TransMessageService;

import java.util.List;

@EnableScheduling
@Configuration
@Component
@Slf4j
public class ResendTask {

    @Autowired
    TransMessageService transMessageService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("#{new Integer('${rising.resendTimes}')}")
    int resendTimes;

    @Scheduled(fixedDelayString = "${rising.resendFreq}")
    public void resendMessage() {
        log.info("resendMessage()");
        List<TransMessage> messagePOS = transMessageService.listReadyMessages();
        log.info("resendMessage():messagePOS:{}", messagePOS);
        for (TransMessage messagePO : messagePOS) {
            log.info("resendMessage(): messagePO:{}", messagePO);
            if (messagePO.getSequence() > resendTimes) {
                log.error("message resend too many times! transMessagePO:{}", messagePO);
                transMessageService.messageDead(messagePO.getId());
                continue;
            }
            //设置消息属性
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setContentType("application/json");
            Message message = new Message(messagePO.getPayload().getBytes(), messageProperties);
            message.getMessageProperties().setMessageId(messagePO.getId());
            //发送
            rabbitTemplate.convertAndSend(messagePO.getExchange(), messagePO.getRoutingKey(),
                    message, new CorrelationData(messagePO.getId()));
            transMessageService.messageResend(messagePO.getId());
        }
    }
}
