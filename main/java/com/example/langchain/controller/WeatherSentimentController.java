package com.example.langchain.controller;

import com.example.langchain.DTO.NationWeatherForecastDTO;
import com.example.langchain.llama.LlamaService;
import com.example.langchain.service.WeatherService;
import com.example.langchain.util.JsonUtil;
import com.example.langchain.util.WeatherForecastDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherSentimentController {
    WeatherService weatherService;

    LlamaService llamaService;

    @Value("${prompts.getBestSkiDaysPrompt}")
    String prompt;

    private static final Logger logger = LoggerFactory.getLogger(WeatherSentimentController.class);

    public WeatherSentimentController(WeatherService weatherService, LlamaService llamaService){

        this.weatherService = weatherService;
        this.llamaService = llamaService;
    }

    public JsonNode extractWeatherData(){
        String response = weatherService.getSevenDaysForecast(108,166);
        JsonNode responseJsonNode = JsonUtil.toJsonNode(response).get("properties").get("periods");

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(NationWeatherForecastDTO.class, new WeatherForecastDeserializer());
        objectMapper.registerModule(module);

        for(JsonNode node : responseJsonNode){

        }





        return responseJsonNode.path("properties").path("periods");
    }
    public void analyzeWeatherData(){

//        String response = llamaService.chat(prompt + extractWeatherData().asText());
//        logger.info(response);
    }
    public void persistSkiingDays(){

    }
}
