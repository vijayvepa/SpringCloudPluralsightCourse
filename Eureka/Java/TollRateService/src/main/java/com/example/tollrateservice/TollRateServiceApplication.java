package com.example.tollrateservice;

import com.example.tollrateclient.TollRateServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@Import(TollRateServiceConfiguration.class)
public class TollRateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollRateServiceApplication.class, args);
	}


}
