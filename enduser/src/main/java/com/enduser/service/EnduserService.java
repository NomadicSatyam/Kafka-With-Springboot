package com.enduser.service;

import com.enduser.config.AppConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnduserService {


    private final List<String> receivedMessages = new ArrayList<>();

    @KafkaListener(topicPartitions = @TopicPartition(topic=AppConstants.LOCATION_UPDATE_TOPIC,partitions = {"1","2"}),groupId = AppConstants.GROUP_ID)
    public void captureLocation(String value){

        receivedMessages.add(value);

    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }
}
