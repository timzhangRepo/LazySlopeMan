package com.example.langchain.service;


import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class WeatherService {
    
    @Value("${weather.api}")
    String weatherAPI;

    ApiService apiService;
    // Constructor - Ensure Singleton & allow baseUrl injection




    public WeatherService(ApiService apiService) {
        this.apiService = apiService;
    }

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    public String getSevenDaysForecast(Integer X, Integer Y) {
        String location = String.format("%d,%d", X, Y);
        String requestURL = weatherAPI.replace("GPS", location);
        logger.info("Getting weather data using weather API");
        String response = apiService.get(requestURL);
        logger.info("Weather data response received");
        logger.info(response);
        return response;
    }
}
