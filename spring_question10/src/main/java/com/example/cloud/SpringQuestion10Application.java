package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringQuestion10Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuestion10Application.class, args);
	}

}