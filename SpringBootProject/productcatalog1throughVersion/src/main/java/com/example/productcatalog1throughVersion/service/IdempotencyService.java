package com.example.productcatalog1throughVersion.service;

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

    public void save(String key,Long productId){
        processedRequest.put(key,productId);
    }
}
