package com.kafka.kafka_producer.service;

import com.kafka.kafka_producer.callback.DemoProducerCallback;
import com.kafka.kafka_producer.config.KafkaTemplateConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private static final String TOPIC ="exam";

    private final KafkaTemplate kafkaTemplate;

    public void sendMessage(String message){
        try{
            System.out.println(String.format("Produce message : %s",message));
            //this.kafkaTemplate.send(TOPIC,message); //Fire-and-forget(전송 후 망각)
            //this.kafkaTemplate.send(TOPIC, message).get();//동기식 전송 카프카의 응답 대기, offset을 알아낼 수 있다.

            //비동기식 전송 , 키가 없는 경우
            //this.kafkaTemplate.send(TOPIC,message).addCallback(new DemoProducerCallback());

            //키가 있는 경우
            this.kafkaTemplate.send(TOPIC, "key", message).addCallback(new DemoProducerCallback());


        } catch (Exception e){
            e.printStackTrace();
        } // try,catch
    }
}
