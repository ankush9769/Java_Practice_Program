package org.example.PaymentThread;

public class Account {
    private double amount = 50000;
    public synchronized void withdraw(double amounts){
        amount = amount - amounts;
        if(amounts<amount){
            System.out.println("balance = "+amount);
//            System.out.println(Thread.currentThread().getName());
        }else{
            System.out.println("insuffient amount");
        }
    }
}
