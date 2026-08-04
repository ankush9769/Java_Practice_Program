package com.zepto.example.repository;

import com.zepto.example.entities.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingRepo extends JpaRepository<Clothing,Integer> {

}
