package com.example.fastpassconsole;

import com.example.fastpassclient.FastPassContract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = {FastPassContract.class})
public class FastpassConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastpassConsoleApplication.class, args);
	}
}
