package com.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DataService {

	@Cacheable("dataCache")
	public String fetchDataFromSlowSource(String parameter) {
		// Simulate a slow data source operation
		try {
			Thread.sleep(5000); // Sleep for 5 seconds to simulate delay
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return "Caching for " + parameter;
	}
}
