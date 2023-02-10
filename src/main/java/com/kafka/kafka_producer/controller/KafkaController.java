package com.kafka.kafka_producer.controller;

import com.kafka.kafka_producer.config.KafkaTemplateConfiguration;
import com.kafka.kafka_producer.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @PostMapping
    public String sendMessage(@RequestParam("message") String message){
        System.out.println("here!");
        this.producer.sendMessage(message);

        return "success";
    }
}
