package com.example.springcloudproducerexample;

public class Toll {

    public String stationId;
    public String customerId;
    public String timestamp;

    public Toll(String stationId, String customerId, String timestamp){
        this.stationId = stationId;
        this.customerId = customerId;
        this.timestamp = timestamp;
    }

}
