package com.masstechBuisnessSolution;

abstract class Payment {
    double amount;
    public Payment(double amount){
        this.amount=amount;
    }
    abstract void processPayment();
}
