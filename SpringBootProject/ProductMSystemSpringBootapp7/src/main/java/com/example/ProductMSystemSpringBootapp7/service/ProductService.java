package com.example.ProductMSystemSpringBootapp7.service;

import com.example.ProductMSystemSpringBootapp7.entities.Product;
import com.example.ProductMSystemSpringBootapp7.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProduct(){
        List<Product> products = productRepo.findAll();
        for(Product product : products){
            System.out.println(product.getCategory().getName());
        }
        return products;
    }


}
