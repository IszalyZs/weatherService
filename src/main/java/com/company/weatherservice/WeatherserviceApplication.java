package com.company.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@EnableCaching
@SpringBootApplication
public class WeatherserviceApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Scheduled(fixedDelay = 15000)
	@CacheEvict(cacheNames = {"weatherdata"} , allEntries=true )
	public void clearCache2(){
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherserviceApplication.class, args);
	}

}
