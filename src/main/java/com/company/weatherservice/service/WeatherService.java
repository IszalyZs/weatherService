package com.company.weatherservice.service;

import com.company.weatherservice.model.WeatherData;
import com.company.weatherservice.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherService {
    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherData getWeather() {
        return weatherRepository.getWeather();
    }
}
