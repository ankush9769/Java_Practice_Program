package org.example.atomic;

public class VolatileType {
    static volatile boolean flag = true;
//    static  boolean flag = true;

    static void main() throws InterruptedException {
        Thread worker = new Thread(
                ()->{
                    System.out.println("worker thread started");
                    while(flag){    //if we set the global variable as volatile then the this will reffer the global veriable

                    }
                    System.out.println("worker thread stopped");
                }
        );
        worker.start();
        Thread.sleep(2000);
        System.out.println("main thread stopped");
        flag=false;

    }
}
