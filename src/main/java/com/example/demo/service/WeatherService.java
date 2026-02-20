package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public String testKey() {
        return apiKey;
    }
}