package resultchecker;

import java.util.Scanner;

public class Primenumberseries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter starting range of number");
        int start = sc.nextInt();
        System.out.println("enter last range of number");
        int last = sc.nextInt();

        for(int i=start ; i<=last ; i++){
            boolean isprime = true;
            for(int j=2 ; j<i ; j++){
                if(i%j==0){
                    isprime = false;
                    break;
                }
            }
            if(isprime){
                System.out.println(i+" is prime number");
            }
        }
    }
}
