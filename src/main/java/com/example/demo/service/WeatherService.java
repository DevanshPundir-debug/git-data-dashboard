package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public String getWeather(String city) {
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=" + apiKey + "&units=metric";

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            String cityName = root.get("name").asText();
            double temp = root.get("main").get("temp").asDouble();
            String condition = root.get("weather").get(0).get("main").asText();

            return "City: " + cityName + "\nTemp: " + temp + "°C\nCondition: " + condition;

        } catch (Exception e) {
            return e.getMessage();
        }
    }

}