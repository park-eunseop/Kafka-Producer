package com.kafka.kafka_producer.config;


import com.kafka.kafka_producer.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaTemplateConfiguration {

    private final KafkaProperties kafkaProperties;

    @Bean
    public KafkaTemplate<String,Object> kafkaTemplate(){
        return new KafkaTemplate<String,Object>(producerFactory());
    }

    @Bean
    public ProducerFactory<String,Object> producerFactory(){
        Map<String,Object> config = new HashMap<>();
        //브로커들의 host:port 목록
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperties.getBootStrapServers());
        //메시지 키 직렬화 (StringSerializer)
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //메시지 값 직렬화 (StringSerializer)
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        return new DefaultKafkaProducerFactory<String,Object>(config);
    }
}
