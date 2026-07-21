package org.example.GoodMorningThread;

public class ChildThreadWish extends Thread{
    GoodMorning g;
    String name;

    public ChildThreadWish(GoodMorning g,String name){
        this.g = g;
        this.name =name;
    }

    public void run(){
        try {
            g.wishing(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
