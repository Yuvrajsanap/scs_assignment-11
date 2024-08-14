package com.example.dependencyinjection;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public String greet() {
		return "Hello, Dependency Injection!";
	}
}
