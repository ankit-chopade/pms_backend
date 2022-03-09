package com.pms.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

	@RequestMapping("/allergyFallback")
	public Mono<String> allergyServiceFallback(){
		return Mono.just("Allergy service taking too long");
	}
	
	@RequestMapping("/diagnosisFallback")
	public Mono<String> diagnosisServiceFallback(){
		return Mono.just("Diagnosis service taking too long");
	}
	@RequestMapping("/procedureFallback")
	public Mono<String> procedureServiceFallback(){
		return Mono.just("Procedure service taking too long");
	}
	@RequestMapping("/medicationFallback")
	public Mono<String> medicationServiceFallback(){
		return Mono.just("Medication service taking too long");
	}
	
	
	
	
}
