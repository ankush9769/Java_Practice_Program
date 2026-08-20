package com.example.productcatalog1throughVersion.repository;

import com.example.productcatalog1throughVersion.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Productsrepo extends JpaRepository<Product,Long> {
    List<Product> findByCategory(String category);
}
