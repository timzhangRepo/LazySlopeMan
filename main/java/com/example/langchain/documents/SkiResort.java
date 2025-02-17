package com.example.langchain.documents;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SkiResort {
    @DBRef
    SiteForcast siteForcast;
}
