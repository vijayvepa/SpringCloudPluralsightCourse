package com.example.tollratebillboard;

import com.example.tollrateclient.TollRateServiceContract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = {TollRateServiceContract.class})
public class TollrateBillboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollrateBillboardApplication.class, args);
	}
}
