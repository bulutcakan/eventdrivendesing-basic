package com.signal.producer.producer;

import com.signal.producer.model.TelemetryModel;
import lombok.Data;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@Data
public class SignalProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;


    public void sendMessage() {
       Random random= new Random();
        for (int i = 0; i < 100; i++) {
            TelemetryModel telemetryModel = new TelemetryModel();
            telemetryModel.setSignalChanel(random.nextLong());
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;;
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            telemetryModel.setSignalPayload(generatedString);
            rabbitTemplate.convertAndSend(exchange, routingKey, telemetryModel);
        }

    }
}