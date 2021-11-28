package com.company.weatherservice.repository;

import com.company.weatherservice.model.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class WeatherRepository {
    private RestTemplate restTemplate;

    @Value(value = "${api.key}")
    public String apiKey;

    private Logger logger = LoggerFactory.getLogger(WeatherRepository.class);

    @Autowired
    public WeatherRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Budapest&appid=" + apiKey + "&units=metric&lang=hu";
        ResponseEntity<WeatherData> entity = restTemplate.getForEntity(url, WeatherData.class);
        return entity.getBody();
    }


}
