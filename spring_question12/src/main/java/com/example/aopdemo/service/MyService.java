package com.example.aopdemo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void performAction() {
        // Simulate some processing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
