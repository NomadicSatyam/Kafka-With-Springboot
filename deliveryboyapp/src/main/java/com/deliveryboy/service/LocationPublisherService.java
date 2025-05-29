package com.deliveryboy.service;

import com.deliveryboy.config.AppConstants;
import com.deliveryboy.model.DriverLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationPublisherService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    public void publishLocation(DriverLocation location) {
        try {
            String key = location.getDriverId();
            String value = mapper.writeValueAsString(location);
            kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
