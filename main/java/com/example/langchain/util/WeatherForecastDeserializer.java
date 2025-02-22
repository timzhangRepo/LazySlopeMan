package com.example.langchain.util;

import com.example.langchain.DTO.NationWeatherForecastDTO;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;

public class WeatherForecastDeserializer extends JsonDeserializer<NationWeatherForecastDTO> {

    @Override
    public NationWeatherForecastDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        NationWeatherForecastDTO nationWeatherForecastDTO = new NationWeatherForecastDTO();

        nationWeatherForecastDTO.setNumber(node.get("number").asInt());
        nationWeatherForecastDTO.setName(node.get("name").asText());
        nationWeatherForecastDTO.setStartTime(node.get("startTime").asText());
        nationWeatherForecastDTO.setEndTime(node.get("endTime").asText());
        nationWeatherForecastDTO.setDaytime(node.get("isDaytime").asBoolean());
        nationWeatherForecastDTO.setTemperature(node.get("temperature").asInt());
        nationWeatherForecastDTO.setTemperatureUnit(node.get("temperatureUnit").asText());

        JsonNode precipitationNode = node.get("probabilityOfPrecipitation");
        if (precipitationNode != null && precipitationNode.has("value") && !precipitationNode.get("value").isNull()) {
            nationWeatherForecastDTO.setProbabilityOfPrecipitation(precipitationNode.get("value").asInt());
        } else {
            nationWeatherForecastDTO.setProbabilityOfPrecipitation(0); // Default value if missing
        }

        nationWeatherForecastDTO.setWindSpeed(node.get("windSpeed").asText());
        nationWeatherForecastDTO.setWindDirection(node.get("windDirection").asText());
        nationWeatherForecastDTO.setIcon(node.get("icon").asText());
        nationWeatherForecastDTO.setShortForecast(node.get("shortForecast").asText());
        nationWeatherForecastDTO.setDetailedForecast(node.get("detailedForecast").asText());


        return nationWeatherForecastDTO;
    }
}
