package org.example.PaymentThread;

import com.sun.security.jgss.GSSUtil;

public class PaymentThread extends Thread{
    public void run(){
        System.out.println("payment started");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("payment completed");
    }
}
