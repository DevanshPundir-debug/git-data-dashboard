package com.example.demo.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public String testKey() {
        return apiKey;
    }

    public String getWeather() {

        String url = "https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);

        return response;
    }
}
