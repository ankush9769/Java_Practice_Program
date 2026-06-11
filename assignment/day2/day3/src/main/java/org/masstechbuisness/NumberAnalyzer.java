package org.masstechbuisness;
import java.util.Scanner;

public class NumberAnalyzer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number =");
        int num = sc.nextInt();
        if(num>=0){
            System.out.println(num+" is positive");
            if(num%2==0){
                System.out.println(num+" is even");
            }else{
                System.out.println(num+" is odd");
            }
        }else{
            System.out.println(num+" is negative");
            if(num%2==0){
                System.out.println(num+" is even");
            }else{
                System.out.println(num+" is odd");
            }
        }
    }
}
