package org.example.Produce_Consume;

public class Consume extends Thread{
    A a;
    Consume(A a) throws InterruptedException {
        this.a = a;
    }

    public void run(){
        try {
            a.consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
