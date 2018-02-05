package com.example.tollrateservice;

import com.example.tollrateclient.TollRate;
import com.example.tollrateclient.TollRateServiceContract;
import com.example.tollrateclient.TollRateServiceInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;

@RestController
public class TollRateController implements TollRateServiceContract {

    @RequestMapping("tollrate/{stationId}")
    public TollRate getTollRate(@PathVariable int stationId){

        String name= TollRateServiceInfo.NAME;
        System.out.print("Station requested: " + stationId);

        TollRate tollRate;

        switch (stationId){
            case 1:
                tollRate = new TollRate(stationId, new BigDecimal("0.55"), Instant.now().toString());
                break;
            case 2:
                tollRate = new TollRate(stationId, new BigDecimal("0.65"), Instant.now().toString());
                break;
            case 3:
                tollRate = new TollRate(stationId, new BigDecimal("0.75"), Instant.now().toString());
                break;
            case 4:
                tollRate = new TollRate(stationId, new BigDecimal("0.85"), Instant.now().toString());
                break;
            default:
                tollRate = new TollRate(stationId, new BigDecimal("1.05"), Instant.now().toString());
                break;


        }

        return tollRate;
    }

}

