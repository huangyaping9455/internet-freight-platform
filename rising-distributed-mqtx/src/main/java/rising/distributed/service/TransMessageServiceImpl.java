package rising.distributed.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rising.distributed.enums.TransMessageType;
import rising.distributed.po.TransMessage;
import rising.distributed.repository.TransMessageRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TransMessageServiceImpl implements TransMessageService {

    @Autowired
    TransMessageRepository transMessageRepository;

    @Value("${moodymq.service}")
    String serviceName;

    @Override
    public TransMessage messageSendReady(String exchange, String routingKey, String body) {
        final String messageId = UUID.randomUUID().toString();
        TransMessage transMessage = new TransMessage();
        transMessage.setId(messageId);
        transMessage.setService(serviceName);
        transMessage.setExchange(exchange);
        transMessage.setRoutingKey(routingKey);
        transMessage.setPayload(body);
        transMessage.setDate(new Date());
        transMessage.setSequence(0);
        transMessage.setType(TransMessageType.SEND);
        transMessageRepository.save(transMessage);
        return transMessage;
    }

    @Override
    public void messageSendSuccess(String id) {
        transMessageRepository.deleteByIdAndService(id, serviceName);

    }

    @Override
    public TransMessage messageSendReturn(String id, String exchange, String routingKey, String body) {
        TransMessage transMessage = new TransMessage();
        transMessage.setId(UUID.randomUUID().toString());
        transMessage.setService(serviceName);
        transMessage.setExchange(exchange);
        transMessage.setRoutingKey(routingKey);
        transMessage.setPayload(body);
        transMessage.setDate(new Date());
        transMessage.setSequence(0);
        transMessage.setType(TransMessageType.SEND);
        transMessageRepository.save(transMessage);
        return transMessage;
    }

    @Override
    public void messageResend(String id) {
        TransMessage transMessage = transMessageRepository.selectByIdAndService(id, serviceName);
        transMessage.setSequence(transMessage.getSequence() + 1);
        transMessageRepository.save(transMessage);
    }

    @Override
    public List<TransMessage> listReadyMessages() {
        return transMessageRepository.selectByTypeAndService(TransMessageType.SEND.name(), serviceName);
    }

    @Override
    public void messageDead(String id, String exchange, String routingKey, String queue, String body) {
        TransMessage transMessage = new TransMessage();
        transMessage.setId(id);
        transMessage.setService(serviceName);
        transMessage.setExchange(exchange);
        transMessage.setRoutingKey(routingKey);
        transMessage.setPayload(body);
        transMessage.setDate(new Date());
        transMessage.setSequence(0);
        transMessage.setType(TransMessageType.DEAD);
        transMessageRepository.save(transMessage);
    }

    @Override
    public void messageDead(String id) {
        TransMessage transMessage = transMessageRepository.selectByIdAndService(id, serviceName);
        transMessage.setType(TransMessageType.DEAD);
        transMessageRepository.save(transMessage);
    }

    @Override
    public TransMessage messageReceiveReady(String id, String exchange, String routingKey, String queue,
                                            String body) {
        TransMessage transMessage = transMessageRepository.selectByIdAndService(id, serviceName);
        if (null == transMessage) {
            transMessage = new TransMessage();
            transMessage.setId(id);
            transMessage.setService(serviceName);
            transMessage.setExchange(exchange);
            transMessage.setRoutingKey(routingKey);
            transMessage.setQueue(queue);
            transMessage.setPayload(body);
            transMessage.setDate(new Date());
            transMessage.setSequence(0);
            transMessage.setType(TransMessageType.RECEIVE);
            transMessageRepository.save(transMessage);
        } else {
            transMessage.setSequence(transMessage.getSequence() + 1);
            transMessageRepository.save(transMessage);
        }
        return transMessage;
    }

    @Override
    public void messageReceiveSuccess(String id) {
        transMessageRepository.deleteByIdAndService(id, serviceName);
    }
}
