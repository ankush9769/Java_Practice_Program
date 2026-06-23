package DataStructure;

import java.util.Scanner;

public class Operation {
    public static void main(String[] args){
        LL list = new LL();
        list.pushfront(100);
        list.pushfront(200);
        list.pushfront(300);
        list.pushfront(400);
        list.pushfront(500);
        list.printforword();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number that you want to serach");
        int search = sc.nextInt();
        list.search(search);
    }
}
