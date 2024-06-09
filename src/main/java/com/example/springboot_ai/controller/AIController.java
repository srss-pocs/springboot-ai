package com.example.springboot_ai.controller;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {
	
	private final ChatClient chatClient;
	
	AIController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
	
	@GetMapping("/ai")
	public Map<String, String> getResponse(@RequestParam String question) {
		String response = chatClient.prompt().user(question).call().content();
        return Map.of("question", question, "answer", response);
	}
	
	

}
