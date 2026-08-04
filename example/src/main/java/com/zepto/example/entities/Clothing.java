package com.zepto.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Clothing {
    @Id
    private int itemId;
    private String itemName;
    private double price;
    private double discount;

}
