package org.example.PaymentThread;

public class MainAccount {
    public static  void main(String[] args){
        Account a = new Account();

        Thread t1 = new Thread(()->{
            a.withdraw(5000);

        },"netbanking");
        Thread t2 = new Thread(()->{
            a.withdraw(6000);
        },"atm");
        System.out.println(t1.getName());
        t1.start();
        System.out.println(t2.getName());
        t2.start();
    }
}
