package com.company.weatherservice.controller;

import com.company.weatherservice.model.WeatherData;
import com.company.weatherservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/")
public class WeatherController {

    private WeatherService weatherService;
    private AtomicLong atomicLong= new AtomicLong(0);

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("weather")
    @Cacheable(value = "weatherdata")
    //@Scheduled(cron ="*/15 * * * * *" )
    public WeatherData getWeather() {
        System.out.println(atomicLong.incrementAndGet());
        return weatherService.getWeather();
    }

}
