package com.deliveryboy.service;


import com.deliveryboy.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private Logger logger = LoggerFactory.getLogger(KafkaService.class);
    public boolean updateLocation(String location)
    {
      this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,0,null,location);

      this.logger.info("message produced");
      return true;
    }

    public boolean updateLocation1(String location)
    {

        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,1,null,location);
        this.logger.info("message produced");
        return true;
    }

    public boolean updateLocation2(String location)
    {

        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,2,null,location);
        this.logger.info("message produced");
        return true;
    }
}
