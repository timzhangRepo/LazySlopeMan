package com.example.langchain.documents;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
@Document(collection = "weather")
public class WeatherForecast {
    Date skiDate; //this is the night before + during the date, and the stamp is actual day light date
    Integer temperature;  // Keep it to C
    Integer PrecipitationProbability;
    Integer windSpeed;
    String shortForecast;
    String detailedForecast;
    Boolean powderDay;
}
