package com.deliveryboy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic driverLocationTopic() {
        return TopicBuilder.name(AppConstants.LOCATION_TOPIC_NAME)
                .partitions(AppConstants.PARTITIONS)
                .replicas(1)
                .build();
    }
}