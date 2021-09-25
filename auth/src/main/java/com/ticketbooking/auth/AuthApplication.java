package com.ticketbooking.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

@EnableEurekaClient
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
	
	
/*	@Bean
	public CorsFilter corsFilter() {
	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	final CorsConfiguration config = new CorsConfiguration();
	System.out.println("cross filter is calling");
	config.setAllowCredentials(true);
	config.addAllowedOrigin("*");
	config.addAllowedHeader("*");
	config.addAllowedMethod("OPTIONS");
	config.addAllowedMethod("HEAD");
	config.addAllowedMethod("GET");
	config.addAllowedMethod("PUT");
	config.addAllowedMethod("POST");
	config.addAllowedMethod("DELETE");
	config.addAllowedMethod("PATCH");
	source.registerCorsConfiguration("/**", config);
	return new CorsFilter(source);
	}*/

}
