package org.example.PaymentThread;

public class MainThread {
    static void main() throws InterruptedException {
        PaymentThread p = new PaymentThread();
        Thread t1 = new Thread(p);
        t1.start();
        t1.join();
        System.out.println("generated invoice");

    }
}
