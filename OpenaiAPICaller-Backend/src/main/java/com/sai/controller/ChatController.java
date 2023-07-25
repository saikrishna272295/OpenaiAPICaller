package com.sai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sai.dto.ChatRequest;
import com.sai.dto.ChatResponse;


/**
 * @author Sai Krishna
 *
 * All rights preserved.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {
    @Autowired
    @Qualifier("openaiRestTemplate")
    private RestTemplate restTemplate;
    
    @Value("${openai.model}")
    private String model;
    
    @Value("${openai.api.url}")
    private String apiUrl;
    
    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam String prompt) {
        ChatRequest request = new ChatRequest(model, prompt);
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return new ResponseEntity<String>("No Response",HttpStatus.OK);
        }
        String res = response.getChoices().get(0).getMessage().getContent();
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }
}
