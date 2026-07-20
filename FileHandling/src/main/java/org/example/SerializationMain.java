package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationMain {
    public  static  void main(String[] args) throws IOException {
        Employee e = new Employee(101,"ankush",20000);
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/emp.ser")))
        {
            outputStream.writeObject(e);
        }
    }
}
