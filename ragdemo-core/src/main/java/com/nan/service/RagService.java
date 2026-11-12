package com.nan.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

import dev.langchain4j.model.openai.OpenAiChatModel;

@Service
public class RagService {

    private final String apiKey;

    public RagService() {
        this.apiKey = System.getenv("OPENAI_API_KEY");
    }

    public String askQuestion(String question) throws IOException {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("OPENAI_API_KEY environment variable is not set");
        }

        String context = Files.readString(
            Path.of("src/main/resources/docs/company-policy.txt"));

        String prompt = "You are a helpful assistant. Use the following context to answer the question.\n\n"
            + "Context:\n"
            + context
            + "\n\nQuestion:\n"
            + question;

        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .build();
        return model.chat(prompt);
    }
}
