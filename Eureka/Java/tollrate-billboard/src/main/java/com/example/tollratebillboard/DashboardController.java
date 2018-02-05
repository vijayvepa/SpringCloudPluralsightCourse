package com.example.tollratebillboard;

import com.example.tollrateclient.TollRate;
import com.example.tollrateclient.TollRateServiceContract;
import com.example.tollrateclient.TollRateServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class DashboardController {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // @Autowired
    // public  RestTemplate restTemplate;

    @Autowired
    public TollRateServiceContract tollRateServiceContract;

    @RequestMapping("/")
    public String getTollRate(@RequestParam int stationId, Model m) {

        String name = TollRateServiceInfo.NAME;

        //TollRate tollRate = TollRateClient.instance().getTollRate(stationId);
        TollRate tollRate = tollRateServiceContract.getTollRate(stationId);
        //TollRate tollRate2 = restTemplate.getForObject(String.format("http://%s/tollrate/%d", TollRateServiceInfo.NAME, stationId) , TollRate.class);

        System.out.println("stationId: " + stationId);
        m.addAttribute("rate", tollRate.currentRate);

        return "dashboard";
    }

}
