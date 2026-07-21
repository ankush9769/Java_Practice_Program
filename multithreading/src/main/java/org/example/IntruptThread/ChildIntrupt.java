package org.example.IntruptThread;

public class ChildIntrupt extends Thread{
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("i got intrupted");
            throw new RuntimeException(e);
        }
    }
}
