package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
    @Value("101")
    private int id;
    @Value("ankush")
    private String name;
    @Value("10000")
    private double price;
    @Value("10")
    private int quintity;

    public Product(int id, String name, double price, int quintity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quintity = quintity;
    }
    public Product(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuintity() {
        return quintity;
    }

    public void setQuintity(int quintity) {
        this.quintity = quintity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quintity=" + quintity +
                '}';
    }


}
