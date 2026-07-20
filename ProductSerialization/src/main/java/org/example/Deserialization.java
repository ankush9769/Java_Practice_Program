package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
    static void main() throws IOException, ClassNotFoundException {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/product.ser")))
        {
            Product p2 = (Product) inputStream.readObject();
            System.out.println(p2);
        }

    }
}
