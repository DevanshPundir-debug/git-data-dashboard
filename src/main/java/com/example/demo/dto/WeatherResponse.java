package com.example.demo.dto;

import java.time.LocalDateTime;

public class WeatherResponse {

    private String city;
    private double temp;
    private String weatherCondition;
    private LocalDateTime timestamp;

    public WeatherResponse(String city, double temp, String weatherCondition, LocalDateTime timestamp) {
        this.city = city;
        this.temp = temp;
        this.weatherCondition = weatherCondition;
        this.timestamp = timestamp;
    }

    public String getCity() {
        return city;
    }

    public double getTemp() {
        return temp;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}