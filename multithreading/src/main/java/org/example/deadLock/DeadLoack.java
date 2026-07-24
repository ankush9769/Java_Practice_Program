package org.example.deadLock;

public class DeadLoack {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    static void main() {
        Thread t1 = new Thread(
                ()->{
                    synchronized (lock1){
                        System.out.println("thread 1 acqure");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (lock2){
                            System.out.println("thread 2 acquier");
                        }
                    }
                }
        );
        Thread t2 = new Thread(
                ()->{
                    synchronized (lock2){
                        System.out.println("thread 2 acqure");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (lock1){
                            System.out.println("thread 1 acquier");
                        }
                    }
                }
        );
        t1.start();
        t2.start();
  //This is a deadlock. One thread is waiting on another thread and the others are waiting on another thread.
    }

}
