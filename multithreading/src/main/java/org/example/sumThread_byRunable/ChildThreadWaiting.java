package org.example.sumThread_byRunable;

public class ChildThreadWaiting extends Thread{
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
