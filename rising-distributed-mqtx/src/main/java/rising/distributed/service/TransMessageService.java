package rising.distributed.service;


import rising.distributed.po.TransMessage;

import java.util.List;

public interface TransMessageService {

    TransMessage messageSendReady(String exchange, String routingKey, String body);

    void messageSendSuccess(String id);

    TransMessage messageSendReturn(String id, String exchange, String routingKey, String body);

    void messageResend(String id);

    void messageDead(String id, String exchange, String routingKey, String queue, String body);

    void messageDead(String id);

    TransMessage messageReceiveReady(String id, String exchange, String routingKey, String queue, String body);

    void messageReceiveSuccess(String id);

    List<TransMessage> listReadyMessages();

}
