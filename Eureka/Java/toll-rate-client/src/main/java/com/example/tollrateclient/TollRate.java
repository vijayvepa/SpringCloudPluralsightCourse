package com.example.tollrateclient;

import java.math.BigDecimal;

public class TollRate {

    public int stationId;
    public BigDecimal currentRate;
    public String timestamp;

    public TollRate(){

    }

    public TollRate(int stationId, BigDecimal currentRate, String timestamp){
        this.stationId = stationId;
        this.currentRate = currentRate;
        this.timestamp = timestamp;
    }
}
