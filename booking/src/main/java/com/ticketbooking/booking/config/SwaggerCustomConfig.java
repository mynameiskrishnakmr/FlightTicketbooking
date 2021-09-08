package com.ticketbooking.booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerCustomConfig {
	
	 @Bean
	    public Docket changeView(){
	        return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        
	        .apis(RequestHandlerSelectors.basePackage("com.ticketbooking.booking"))

	        .build()
	        .apiInfo(getApiInfo())
	        ;
	    }
	 
	  private ApiInfo getApiInfo(){
	        return new ApiInfoBuilder()
	            .title("Booking Microservice ")
	            
	            .version("1.0")
	            .description("Users can Book flights, View tickets, Cancel tickets, View booking history ")
	            .build();
	    }

}
