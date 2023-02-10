package com.kafka.kafka_producer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {
    @Value("${bootstrap-servers}")
    private String bootStrapServers;

    @Value("${test}")
    private String test;
}
