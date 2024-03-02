package com.enduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

@Configuration
public class KafkaConfig {


    @KafkaListener(groupId = AppConstants.GROUP_ID,topicPartitions = @TopicPartition(topic=AppConstants.LOCATION_UPDATE_TOPIC,partitions = {"0"}))
    public void updatedLocation(String value) {

        System.out.println(value);

    }

}
