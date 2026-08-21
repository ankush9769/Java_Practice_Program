package com.example.productcatalog1throughVersion.service;

import com.example.productcatalog1throughVersion.dto.Requestdto;
import com.example.productcatalog1throughVersion.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Productservice {
    Page<Product> getAll(int page, int size);

    Page<Product> getProductInOrder(int page , int size, String sortBy, String direction);

    List<Product> getByCategory(String category);

}
