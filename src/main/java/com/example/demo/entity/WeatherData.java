package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private double temp;
    private String weatherCondition;

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getCondition() {
        return weatherCondition;
    }

    public void setCondition(String condition) {
        this.weatherCondition = condition;
    }

}