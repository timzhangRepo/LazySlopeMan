package com.example.langchain.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts a JSON string into a JsonNode.
     *
     * @param jsonString The JSON string to convert.
     * @return JsonNode representation of the JSON.
     * @throws RuntimeException if parsing fails.
     */
    public static JsonNode toJsonNode(String jsonString) {
        try {
            return objectMapper.readTree(jsonString);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string", e);
        }
    }

    public static JsonNode toJsonNode(Object object) {
        try {
            return objectMapper.valueToTree(object); // Converts any Java object to JsonNode
        } catch (Exception e) {
            throw new RuntimeException("Error converting to JsonNode", e);
        }
    }
}