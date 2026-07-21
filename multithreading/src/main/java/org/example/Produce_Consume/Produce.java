package org.example.Produce_Consume;

public class Produce extends Thread {
    A a;
    Produce(A a){
        this.a = a;
    }
    public void run(){
        try {
            a.produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
