package com.example.kafka0809_1.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class testCunsumer implements IKafkaListener {
    @Override
    public void listener(ConsumerRecord<?, ?> record) {
        System.out.println(record.value());
        System.out.println(record.topic());
    }
}
