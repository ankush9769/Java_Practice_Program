package com.masstechBuisnessSolution;
import java.util.ArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Upi u1 = new Upi(2000,"ankush@9769");
        NetBanking n1 = new NetBanking(5000,"union_bank");
        CreditCard c1 = new CreditCard(10000,87976);

        ArrayList<Payment> list = new ArrayList<Payment>();
        list.add(u1);
        list.add(n1);
        list.add(c1);

        System.out.println(list);
        u1.processPayment();
        c1.processPayment();
        n1.processPayment();
    }
}
