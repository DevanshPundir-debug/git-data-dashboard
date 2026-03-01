package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private double temp;
    private String condition;

}