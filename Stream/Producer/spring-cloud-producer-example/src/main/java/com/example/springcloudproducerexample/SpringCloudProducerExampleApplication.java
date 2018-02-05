package com.example.springcloudproducerexample;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(TollSource.class)
public class SpringCloudProducerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProducerExampleApplication.class, args);
	}

	@Bean
	@InboundChannelAdapter(channel = TollSource.fastPassTollChannel, poller = @Poller(fixedDelay = "2000"))
	public MessageSource<Toll> sendTollCharge(){
		return  ()->  MessageBuilder.<Toll>withPayload(new Toll("20", "100", "2017-12-12")).build();
	}

}
