package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public String testKey() {
        return apiKey;
    }

    public Map<String, Object> getWeather(String city)  {

        try {
//            String url = "https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=" + apiKey + "&units=metric";
            String url = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city +
                    "&appid=" + apiKey +
                    "&units=metric";

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            String cityName = root.get("name").asText();
            double temp = root.get("main").get("temp").asDouble();
            String condition = root.get("weather").get(0).get("main").asText();

            Map<String, Object> data = new HashMap<>();
            data.put("city", cityName);
            data.put("temp", temp);
            data.put("condition", condition);

            return data;

//            return "City: " + cityName + "\nTemp: " + temp + "°C\nCondition: " + condition;

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", e.getMessage());
            return error;
        }
    }
//form
}