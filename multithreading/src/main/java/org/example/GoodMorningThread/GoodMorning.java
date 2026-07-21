package org.example.GoodMorningThread;

public class GoodMorning {
    //        public synchronized  void wishing(String name) throws InterruptedException {
    public synchronized  void wishing(String name) throws InterruptedException {
        for(int i=0;i<10;i++){
            System.out.println("good morning "+name);
            Thread.sleep(1000);
        }
    }
}
