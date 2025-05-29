package com.enduser.consumer;

import com.enduser.config.AppConstants;
import com.enduser.model.DriverLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RiderLocationConsumerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void consume(ConsumerRecord<String, String> record) {
        try {
            String key = record.key();
            String value = record.value();

            DriverLocation location = objectMapper.readValue(value, DriverLocation.class);

            System.out.println("📡 Location update received for driver " + location.getDriverId());
            System.out.println("   Coordinates: " + location.getLatitude() + ", " + location.getLongitude());
            System.out.println("   Time: " + location.getTimestamp());

            notifyRider(location);
            notifySharedUsers(location);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void notifyRider(DriverLocation location) {
        System.out.println("📨 Rider notified: Driver " + location.getDriverId() + " location updated.");
    }

    private void notifySharedUsers(DriverLocation location) {
        System.out.println("📨 Shared users notified: Driver " + location.getDriverId() + " location updated.");
    }
}