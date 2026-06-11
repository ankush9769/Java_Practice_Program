package com.masstechBuisnessSolution;

public class Upi extends Payment{
    String upid;
    double transaction_amount;
    public Upi(double amount,String upi_id){
        super(amount);
        this.upid=upi_id;
    }
    @Override
    void processPayment() {
        System.out.println("processing UPI payment");
        System.out.println("UPI id ="+upid);
        System.out.println("Amount = "+amount);
        System.out.println("Payment successfull");

        transaction_amount = 0;
        System.out.println("Transaction charge = "+transaction_amount);
        System.out.println("Final Amount Debited="+(amount+transaction_amount));
        System.out.println("");
    }
}
