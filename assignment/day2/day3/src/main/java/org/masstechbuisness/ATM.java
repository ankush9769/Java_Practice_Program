package org.masstechbuisness;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int pin = 8080;
        int attempt = 3;
        while(attempt != 0){
            System.out.println("enter ATM pin = ");
            int num = sc.nextInt();
            if(num == pin){
                System.out.println("successfully login");
                System.out.println("welcome to ATM services");
                break;
            }else{
                attempt--;
                System.out.println("invalid PIN: attempts remaining "+attempt);
            }
        }
    }
}
