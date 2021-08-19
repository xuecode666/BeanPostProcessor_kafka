package com.example.kafka0809_1.config;

// KafkaConfiguration.java


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfiguration {
    /**
     * 以逗号分隔的主机：端口对列表，用于建立与Kafka群集的初始连接
     */
    @Value("${kafka.bootstrap-servers}")
    private String servers;
    /**
     * 如果为true，则消费者的偏移量将在后台定期提交，默认值为true
     */
    @Value("${kafka.consumer.enable-auto-commit}")
    private boolean enableAutoCommit;
    /**
     * 心跳与消费者协调员之间的预期时间（以毫秒为单位），默认值为3000
     */
    @Value("${kafka.consumer.auto-commit-interval}")
    private String autoCommitInterval;
    /**
     * 当Kafka中没有初始偏移量或者服务器上不再存在当前偏移量时该怎么办，默认值为latest，表示自动将偏移重置为最新的偏移量 可选的值为latest, earliest, none
     */
    @Value("${kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;
    /**
     * 在监听器容器中运行的线程数
     */
    @Value("${kafka.consumer.concurrency}")
    private int concurrency;
    /**
     * 一次调用poll()操作时返回的最大记录数，默认值为500
     */
    @Value("${kafka.consumer.max-poll-records}")
    private int maxPollRecords;
    /**
     * 用于标识此使用者所属的使用者组的唯一字符串
     */
    @Value("${kafka.consumer.group-id}")
    private String groupId;

    /**
     * 消费者批量工厂
     */
    @Bean
    public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs()));
        /*// 并发创建的消费者数量
        factory.setConcurrency(1);
        // 设置为批量消费，每个批次数量在Kafka配置参数中设置ConsumerConfig.MAX_POLL_RECORDS_CONFIG
        factory.setBatchListener(true);
        factory.getContainerProperties().setPollTimeout(1500);*/
        return factory;
    }

    /**
     * 消费者配置信息
     */
    private Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>(16);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, 10485760);
        props.put(ConsumerConfig.RECEIVE_BUFFER_CONFIG, 10485760);
        return props;
    }

}