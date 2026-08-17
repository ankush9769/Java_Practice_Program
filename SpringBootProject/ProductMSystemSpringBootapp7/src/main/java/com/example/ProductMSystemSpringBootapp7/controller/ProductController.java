package com.example.ProductMSystemSpringBootapp7.controller;

import com.example.ProductMSystemSpringBootapp7.entities.Product;
import com.example.ProductMSystemSpringBootapp7.repo.ProductRepo;
import com.example.ProductMSystemSpringBootapp7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//json--->c
//c---->json
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

}
