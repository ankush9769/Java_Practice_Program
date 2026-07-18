package Same;

import java.util.Scanner;

public class NUM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Numerator:");
        int numerator = sc.nextInt();
        System.out.println("Enter a Denominator:");
        int denominator = sc.nextInt();
        String str = null;
        try {
            int res = numerator / denominator;
            System.out.println("Result = " + res);
        }
        catch (Exception e) {
            if (e instanceof ArithmeticException) {
                System.out.println("Please enter a valid denominator (not 0).");
            }
        }
        sc.close();
    }
}