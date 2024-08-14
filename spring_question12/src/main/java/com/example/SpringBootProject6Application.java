package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootProject6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject6Application.class, args);
	}
}
//localhost:8080