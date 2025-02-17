package com.example.langchain.crawlers;


import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.jsoup.nodes.Document;
import java.util.HashMap;

@Component
public class SkiSitesCrawler {

    @Value("${resorts.snowbird.site}")
    String resortSite;
    Logger logger = LoggerFactory.getLogger(SkiSitesCrawler.class);
    public String seekContent(){
        try{
            logger.info("scrapping {}", resortSite);
            Document doc = Jsoup.connect(resortSite).get();
            logger.info("scrapping complete {}",resortSite);
            return doc.body().text();
        }catch(Exception e){
            //TODO create custom exception class and add it in the springboot classes fodler, to make this code more maintianbale
            logger.info("Some exception happened during getting content from the websites");
            throw new RuntimeException(e);
        }
    }
    //TODO write this to a database, you don't want everything fucking happenw sync, every fucking thing should be async
}
