package org.example.Produce_Consume;

public class MainPC {
    static void main() throws InterruptedException {
        A a = new A();
        Produce p = new Produce(a);
        Consume c = new Consume(a);
        p.start();
        c.start();

    }



}
