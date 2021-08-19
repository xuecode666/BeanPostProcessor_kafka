package com.example.kafka0809_1.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;


public interface IKafkaListener {
    void listener(ConsumerRecord<?, ?> record);
}
