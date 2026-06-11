package com.masstechBuisnessSolution;

public class CreditCard extends Payment{
     int creditno;
    double transaction_amount;
     public CreditCard(double amount,int creditno){
         super(amount);
         this.creditno=creditno;
     }
    @Override
    void processPayment() {
        System.out.println("processing Credit Card Payment");
        System.out.println("Card no.="+creditno);
        System.out.println("Amount = "+amount);
        System.out.println("Payment successfully");

        transaction_amount = 0.02*amount;
        System.out.println("Transaction charge = "+transaction_amount);
        System.out.println("Final Amount Debited="+(amount+transaction_amount));
        System.out.println(" ");


    }
}
