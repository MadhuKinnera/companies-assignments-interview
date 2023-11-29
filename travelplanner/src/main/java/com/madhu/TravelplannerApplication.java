package com.madhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	    info = @Info(
	        title = " Wanderlust Travel Planner API DOC ",
	        version = "1.0",
	        description = "API documentation for Wanderlust Application",
	        license = @License(name = "License")
	    ),
	    servers = @Server(url = "/",description = "Default Server URL")
	    
	)
@SpringBootApplication
public class TravelplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelplannerApplication.class, args);
	}

}
