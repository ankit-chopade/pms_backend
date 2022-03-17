package com.pms.visit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PmsVisitApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(PmsVisitApplication.class, args);
	}
	

}
