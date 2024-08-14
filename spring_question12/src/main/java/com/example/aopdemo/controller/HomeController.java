package com.example.aopdemo.controller;

import com.example.aopdemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final MyService myService;

    @Autowired
    public HomeController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        myService.performAction();  // Example usage of the service
        return "Action performed. Check the console for execution time.";
    }
}
