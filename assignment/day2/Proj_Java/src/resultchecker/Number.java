package resultchecker;

import java.util.Scanner;

public class Number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("enter number =");
        int num = sc.nextInt();
        int securenum=num;
        int count=0;
        int sum=0;
        int reverse=0;
        int armsum =0 ;

        while(num!=0){
            int rem = num%10;
            num = num/10;
            sum = sum+rem;
            reverse = (reverse*10)+rem;
            count++;
        }

        System.out.println("total count of the digit ="+count);
        System.out.println("total sum of the digit is ="+sum);
        System.out.println("reverse of the number is ="+reverse);

        num = securenum;
        while(num!=0){
            int rem = num%10;
            armsum = armsum+(int)Math.pow(rem,count);
            num = num/10;
        }
        if(armsum == securenum){
            System.out.println("yes "+securenum+" is armstrong number");
        }else{
            System.out.println("no "+securenum+" is not armstrong number");
        }


    }
}
