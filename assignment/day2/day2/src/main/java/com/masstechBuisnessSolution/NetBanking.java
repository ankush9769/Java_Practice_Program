package com.masstechBuisnessSolution;

public class NetBanking extends Payment{
    String bank_name;
    double transaction_amount;
    public NetBanking(double amount,String bank_name){
        super(amount);
        this.bank_name=bank_name;
    }
    @Override
    void processPayment() {
        System.out.println("Processing NetBanking");
        System.out.println("Bank Name ="+bank_name);
        System.out.println("Amount = "+amount);
        System.out.println("Payment successfully");


        transaction_amount = 0.01*amount;
        System.out.println("Transaction charge = "+transaction_amount);
        System.out.println("Final Amount Debited="+(amount+transaction_amount));
        System.out.println(" ");
    }
}
