import com.example.langchain.LangChainApp;
import com.example.langchain.controller.WeatherSentimentController;
import com.example.langchain.crawlers.SkiSitesCrawler;
import com.example.langchain.llama.LlamaService;
import com.example.langchain.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LangChainApp.class)
public class Scratch {
    @Autowired
    LlamaService llamaService;
    @Autowired
    SkiSitesCrawler skiSitesCrawler;
    @Autowired
    WeatherSentimentController weatherSentimentController;
    @Autowired
    WeatherService service;
    @Test
    public void testMyMethod() {
        // Call the method you want to test677429
        // Print the result (optional)

    }
    @Test
    public void getWeatherData(){
        service.getSevenDaysForecast(108, 166);
    }
    @Test
    public void analyzeWeatherData(){
        weatherSentimentController.analyzeWeatherData();
    }
}