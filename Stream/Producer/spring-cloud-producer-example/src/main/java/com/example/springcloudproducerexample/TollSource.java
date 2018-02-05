package com.example.springcloudproducerexample;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TollSource {

    public static final String fastPassTollChannel = "fastPassTollChannel";
    public static final String standardTollChannel = "standardTollChannel";

    @Output(TollSource.fastPassTollChannel)
    MessageChannel fastPassToll();

    @Output(TollSource.standardTollChannel)
    MessageChannel standardToll();
}
