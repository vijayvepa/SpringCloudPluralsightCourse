package com.example.eurekaserverexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverExampleApplication.class, args);
	}
}
