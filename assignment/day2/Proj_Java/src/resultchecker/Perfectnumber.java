package resultchecker;

import java.util.Scanner;

public class Perfectnumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number to check the perfect number");
        int num = sc.nextInt();
        int sum =0;
        for(int i = 1 ; i<num ;i++){
            if(num%i==0){
                sum = sum+i;
            }
        }
        if(sum == num){
            System.out.println("yes "+num+" is perfect number");
        }else{
            System.out.println("no "+num+" is not perfect number");
        }
    }
}
