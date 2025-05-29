package com.deliveryboy.controller;

import com.deliveryboy.model.DriverLocation;
import com.deliveryboy.service.LocationPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DriverLocationController {

    @Autowired
    private LocationPublisherService locationPublisherService;

    @PostMapping("/updateLocation")
    public String updateLocation(@RequestBody DriverLocation location) {
        locationPublisherService.publishLocation(location);
        return "Location update published successfully.";
    }
}
