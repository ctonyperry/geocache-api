package com.example.geocacheapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class GeocacheApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeocacheApiApplication.class, args);
	}
}
