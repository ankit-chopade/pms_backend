package com.pms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PmsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsGatewayApplication.class, args);
	}

}
