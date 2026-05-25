package com.krishi_mitra.service;


import com.krishi_mitra.dto.response.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeatherByCity(String city);
}
