package com.pms.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsWebFilterCustom{
	 @Bean
	    public CorsWebFilter corsFilter() {
	        return new CorsWebFilter(corsConfigurationSource());
	    }

	    @Bean
	    UrlBasedCorsConfigurationSource corsConfigurationSource() {
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
	        config.addAllowedHeader("*");
	        config.addAllowedMethod( HttpMethod.GET);
	        config.addAllowedMethod( HttpMethod.PUT);
	        config.addAllowedMethod( HttpMethod.POST);
	        config.addAllowedMethod(HttpMethod.DELETE);
	        
	        source.registerCorsConfiguration("/**", config);
	        return source;
	    }
}
