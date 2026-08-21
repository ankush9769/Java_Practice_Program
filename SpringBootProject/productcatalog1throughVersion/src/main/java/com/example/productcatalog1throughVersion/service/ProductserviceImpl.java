package com.example.productcatalog1throughVersion.service;

import com.example.productcatalog1throughVersion.dto.Requestdto;
import com.example.productcatalog1throughVersion.entity.Product;
import com.example.productcatalog1throughVersion.exception.ResourceNotFoundException;
import com.example.productcatalog1throughVersion.repository.Productsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductserviceImpl implements Productservice {
    @Autowired
    Productsrepo productsrepo;

    @Override
    public Page<Product> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productsrepo.findAll(pageable);
    }

    @Override
    public Page<Product> getProductInOrder(int page, int size, String sortBy, String direction) {
        Sort sort;
        if (direction.equalsIgnoreCase("desc")){
            sort=Sort.by(sortBy).descending();
        }else {
            sort= Sort.by(sortBy).ascending();
        }
        Pageable pageable  = PageRequest.of(page,size,sort);
        return productsrepo.findAll(pageable);
    }

    @Override
    public List<Product> getByCategory(String category){
        return productsrepo.findByCategory(category);
    }


    @Cacheable(value = "product",key = "#id")
    public Product findById(Long id){
        return productsrepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Products not found"));
    }

    public void deleteById(Long id){
        productsrepo.deleteById(id);
    }

    public Product createProduct(Requestdto product) {
        Product productNew = new Product();
        productNew.setName(product.getName());
        productNew.setCategory(product.getCategory());
        productNew.setPrice(product.getPrice());
        productNew.setStock(product.getStock());
        return productsrepo.save(productNew);
    }

    public Product updateProduct(Long id, Requestdto request) {

        Product product = productsrepo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Product not found with id: " + id
                ));

        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        return productsrepo.save(product);
    }
}
