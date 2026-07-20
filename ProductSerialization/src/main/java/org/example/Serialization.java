package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serialization {
    static void main() throws IOException {
        Product p = new Product(101,"iphone",10,10000,"iphne10");
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/product.ser")))
        {
            outputStream.writeObject(p);
        }
    }
}
