package com.kafka.kafka_producer.callback;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class DemoProducerCallback implements ListenableFutureCallback {

    @Override
    public void onFailure(Throwable ex) {

    }

    @Override
    public void onSuccess(Object result) {
        System.out.println("onSuccess!");
        System.out.println(result.toString());
        // 레코드 정보 포함 정보(topic=exam, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), 
        // key=null, value=student, timestamp=null), recordMetadata=exam-0@7]
    }
}
