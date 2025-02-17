package com.example.langchain.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {
    private final WebClient webClient;
    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();  // No hardcoded baseUrl
    }

    public String get(String baseUrl) {
        return webClient.mutate()
                .baseUrl(baseUrl)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
