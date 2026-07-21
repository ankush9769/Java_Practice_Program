package org.example.sumThread_byImplements;

public class ChildTSum implements Runnable{
 static int sum =0;
    @Override
    public void run() {
        for(int i =0;i<=10;i++){
            sum = sum +i;
        }
    }
}
