package com.example.flightBookingSystmeSBapp10.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IdempotencyService {
    private final Map<String,Long> processedRequest = new ConcurrentHashMap<>();

    public boolean isProcessed(String key){
        return processedRequest.containsKey(key);
    }

    public Long getProductId(String key){
        return processedRequest.get(key);
    }

    public void store(String key,Long ticketId){
        processedRequest.put(key,ticketId);
    }
}
