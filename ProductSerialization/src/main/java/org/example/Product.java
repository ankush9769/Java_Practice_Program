package org.example;

import java.io.Serializable;

public class Product implements Serializable {
    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", password='" + password + '\'' +
                '}';
    }

    private int pid;
    private String name;
    private int quantity;
    private double price;
    transient String password;  //transient is used for do not serialized this field

    public Product(int pid, String name, int quantity, double price, String password) {
        this.pid = pid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.password = password;
    }




}
