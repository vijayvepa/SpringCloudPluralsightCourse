package com.example.tollrateclient;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;


public class TollRateClient {

    public static TollRateServiceContract instance(){
        return Feign.builder()
                .client(new OkHttpClient())

                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(TollRateServiceContract.class))
                .logLevel(Logger.Level.FULL)
                .target(TollRateServiceContract.class,
                        String.format("http://%s/", TollRateServiceInfo.NAME));
    }
}
