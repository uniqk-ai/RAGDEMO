package com.nan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nan.service.RagService;

@RestController 
@RequestMapping ("/chat")
public class ChatController {
    private final RagService ragService;

    public ChatController(RagService ragService) {
        this.ragService = ragService;
    }

    @GetMapping 
    public String ask(@RequestParam String question) throws Exception {
        return ragService.askQuestion(question);
    }
}
