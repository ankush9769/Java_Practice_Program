package com.example.productcatalog1throughVersion;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerV2 {

    @GetMapping("/v2")
    public String method2(){
        return "this returning from version 2";
    }
}
