package com.example.demo.dto;

public class WeatherResponse {

    private String city;
    private double temp;
    private String weatherCondition;

    public WeatherResponse(String city, double temp, String weatherCondition) {
        this.city = city;
        this.temp = temp;
        this.weatherCondition = weatherCondition;
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
}
