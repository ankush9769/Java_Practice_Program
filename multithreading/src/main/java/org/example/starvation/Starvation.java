package org.example.starvation;

public class Starvation {
    public static final Object lock = new Object();

    static void main() {
        Thread highePrio = new Thread(
                ()->{
                    while(true){
                        synchronized (lock){
                            System.out.println("high priority");
                        }
                    }
                }
        );
        Thread lowPrio = new Thread(
                ()->{
                    while(true){
                        synchronized (lock){
                            System.out.println("low priority");
                        }
                    }
                }
        );
        highePrio.setPriority(Thread.MAX_PRIORITY);
        lowPrio.setPriority(Thread.MIN_PRIORITY);
        highePrio.start();
        lowPrio.start();
    }

}
