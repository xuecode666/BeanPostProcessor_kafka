package com.example.kafka0809_1.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**

 * 把KafkaConsumerListener注册到SpringIOC之中
 */

@Configuration
public class CreateKafkaListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public KafkaListenerInitConfig init() {
        return new KafkaListenerInitConfig();
    }
}
