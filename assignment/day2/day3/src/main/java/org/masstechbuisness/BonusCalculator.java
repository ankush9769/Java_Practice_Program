package org.masstechbuisness;
import java.util.Scanner;

public class BonusCalculator {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your name = ");
        String name  = sc.next();
        System.out.println("enter your salary");
        double salary = sc.nextDouble();
        System.out.println("enter your performance rating eg..(A,B,C,D)");
        String rating = sc.next();

        switch (rating){
            case "A":{
                System.out.println("name = "+name);
                System.out.println("salary = "+salary);
                System.out.println("bonus amount = "+(salary*0.2));
                System.out.println("final salary = "+(salary+(salary*0.2)));
                break;
            }
            case "B":{
                System.out.println("name = "+name);
                System.out.println("salary = "+salary);
                System.out.println("bonus amount = "+(salary*0.15));
                System.out.println("final salary = "+(salary+(salary*0.15)));
                break;
            }
            case "C":{
                System.out.println("name = "+name);
                System.out.println("salary = "+salary);
                System.out.println("bonus amount = "+(salary*0.1));
                System.out.println("final salary = "+(salary+(salary*0.1)));
                break;
            }
            case "D":{
                System.out.println("name = "+name);
                System.out.println("salary = "+salary);
                System.out.println("bonus amount = "+(salary*0.05));
                System.out.println("final salary = "+(salary+(salary*0.05)));
                break;
            }
            default:
                System.out.println("enter valid rating ");
        }
    }
}
