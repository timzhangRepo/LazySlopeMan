package com.example.langchain.llama;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static dev.langchain4j.model.chat.request.ResponseFormat.JSON;

@Service
public class LlamaService implements Assistant {

    private final OllamaChatModel model;
    private final List<ChatMessage> chatHistory = new ArrayList<>();

    public LlamaService() {
        // 选择你下载的 LLM，例如 "mistral" 或 "llama2"
        this.model = OllamaChatModel.builder()
                .temperature(0.4)
                .responseFormat(JSON) // Ensure JSON is correctly imported
                .modelName("llama2")
                .logRequests(true)
                .baseUrl("http://127.0.0.1:11434")
                .build();
    }

    public String chat(String userMessage) {
        String response = model.chat(userMessage);
        return response;
    }

//    @Bean
//    public ChatMemoryProvider chatMemoryProvider() {
//        return memoryId -> new InMemoryChatMemory(10); // Store last 10 messages
//    }

}