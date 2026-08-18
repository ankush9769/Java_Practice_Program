package com.example.productcatalog1throughVersion.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerV1 {
    @GetMapping("/v1")
    public String method1(){
        return "returning from version 1";
    }

}
