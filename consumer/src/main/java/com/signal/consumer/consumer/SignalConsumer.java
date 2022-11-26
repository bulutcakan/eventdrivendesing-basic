package com.signal.consumer.consumer;

import com.signal.consumer.model.TelemetryModel;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Data
public class SignalConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignalConsumer.class);
   private final SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(TelemetryModel telemetryModel) {
        simpMessagingTemplate.convertAndSend("/topic/pushmessages",telemetryModel);
        LOGGER.info(telemetryModel.toString());
    }
}
