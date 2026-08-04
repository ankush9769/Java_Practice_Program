package com.zepto.example.service;

import com.zepto.example.entities.Clothing;
import com.zepto.example.repository.ClothingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingService {
    @Autowired
    private ClothingRepo clothingRepo;

    public void add(Clothing clothing){
        clothingRepo.save(clothing);
    }
    public void addAll(List<Clothing> clothing){
        clothingRepo.saveAll(clothing);
    }
    public Clothing get(int id){
        return clothingRepo.findById(id).get();
    }
    public List<Clothing> getAll(){
        return clothingRepo.findAll();
    }
    public void deleteById(int id){
        clothingRepo.deleteById(id);
    }
    public void deleteAll(){
        clothingRepo.deleteAll();
    }
    public void update(int id,Clothing clothing){
        Clothing clothing1 = clothingRepo.findById(id).get();
        clothing1.setItemName(clothing.getItemName());
        clothingRepo.save(clothing1);
    }

}
