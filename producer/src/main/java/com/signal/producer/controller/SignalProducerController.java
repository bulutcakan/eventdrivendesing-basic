package com.signal.producer.controller;

import com.signal.producer.producer.SignalProducer;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
@Data
public class SignalProducerController {
    private final SignalProducer producer;
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(){
        producer.sendMessage();
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }
}
