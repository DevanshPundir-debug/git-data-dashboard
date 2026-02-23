//package controller;
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.WeatherService;

@RestController
public class TestController {

    private final WeatherService weatherService;

    public TestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/test")
    public String test() {
        return "project working";
    }

    @GetMapping("/check-key")
    public String checkKey() {
        return weatherService.testKey();

    }
    @GetMapping("/weather")
    public String getWeather() {
        return weatherService.getWeather();
    }
}