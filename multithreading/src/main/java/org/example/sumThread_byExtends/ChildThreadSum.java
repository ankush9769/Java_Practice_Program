package org.example.sumThread_byExtends;

public class ChildThreadSum extends Thread{
    public static int sum =0;
    public void run(){
        for(int i =0;i<=10;i++){
            sum = sum +i;
        }
        System.out.println(sum);
    }
}
