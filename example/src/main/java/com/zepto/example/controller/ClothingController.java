package com.zepto.example.controller;

import com.zepto.example.entities.Clothing;
import com.zepto.example.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ClothingController")
public class ClothingController {

    @Autowired
    private ClothingService clothingService;

    @PostMapping("/addClothing")
    public void addClothing(@RequestBody Clothing clothing){
        clothingService.add(clothing);
    }

    @PostMapping("/addAllClothing")
    public void addAllClothing(@RequestBody List<Clothing> clothingList){
        clothingService.addAll(clothingList);
    }
// @RequestParam(required = false)
    @GetMapping("/findbyid/{id}")
    public Clothing get( @PathVariable int id){
        return clothingService.get(id);
    }

    @GetMapping("/findALl")
    public List<Clothing> getAll(){
        return clothingService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        clothingService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        clothingService.deleteAll();
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id,@RequestBody Clothing data){
        clothingService.update(id,data);
    }


}
