package org.masstechbuisness;

import java.util.Scanner;

public class AtmSimulation {
    public static void main(String[] args){
        double accountBalance = 50000;
        Scanner sc = new Scanner(System.in);
        String lastprocess = "init";
        double lastamount=0;
        boolean isexit = true;
        while(isexit){
            System.out.println("press");
            System.out.println("1 for check balance");
            System.out.println("2 for Deposit Money");
            System.out.println("3 for withdrow Money");
            System.out.println("4 for Mini statement");
            System.out.println("5 for exit");
            int input = sc.nextInt();


            switch (input){
                case 1:{
                    System.out.println("your current account balance is ="+accountBalance);
                    break;
                }
                case 2:{
                    System.out.println("enter your money amount to deposite=");
                    double deposite = sc.nextDouble();
                    if(deposite<0){
                        System.out.println("enter +ve amount");
                    }else{
                        accountBalance= accountBalance+deposite;
                        System.out.println("deposite amount successfully");
                        System.out.println("your updated balance is ="+accountBalance);
                        lastprocess="deposite";
                        lastamount=deposite;
                    }
                    break;

                }
                case 3:{
                    System.out.println("enter your money amount to withdrow=");
                    double withdrow = sc.nextDouble();
                    if(withdrow<0){
                        System.out.println("enter +ve amount");
                    }else{
                        accountBalance= accountBalance+withdrow;
                        System.out.println("withdrow amount successfully");
                        System.out.println("your updated balance is ="+accountBalance);
                        lastprocess="withdrow";
                        lastamount=withdrow;
                    }
                    break;
                }
                case 4:{
                    System.out.println("last transaction details");
                    System.out.println("payment process="+lastprocess);
                    System.out.println("payment amount="+lastamount);
                    System.out.println("balance amount ="+accountBalance);
                    break;
                }
                case 5:{
                    isexit=false;
                    break;
                }
                default:{
                    System.out.println("invalid inpute");
                }
            }
        }
    }
}
