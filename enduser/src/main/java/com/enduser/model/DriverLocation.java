package com.enduser.model;

import lombok.Data;

@Data
public class DriverLocation {

    private String driverId;
    private double latitude;
    private double longitude;
    private String timestamp;
}
