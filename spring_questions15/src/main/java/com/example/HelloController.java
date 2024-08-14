package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final DataService dataService;

    public HelloController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/api/data")
    public String getData(@RequestParam String parameter) {
        return dataService.fetchDataFromSlowSource(parameter);
    }
}
