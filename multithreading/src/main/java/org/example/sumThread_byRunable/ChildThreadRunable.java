package org.example.sumThread_byRunable;

import org.example.sumThread_byExtends.ChildThreadSum;

public class ChildThreadRunable extends Thread {
    static  int  sum =0;
    static void main() throws InterruptedException {
        Runnable r = ()->{

            for(int i =0;i<=10;i++){
                sum = sum +i;
            }
        };

        Thread t1=new Thread(r);
        ChildThreadWaiting ct1 = new ChildThreadWaiting();
        Thread t2 = new Thread(ct1);


     //   System.out.println(t1.getState());   // NEW
        System.out.println(t2.getState());
        t1.start();
        t2.start();
        System.out.println(t1.getState());   // RUNNING OR RUNNABLE
        System.out.println(t2.getState());

    //    Thread.sleep(1000);
        t2.join();//main-->waiting

       // System.out.println(sum);
        System.out.println(Thread.currentThread().getName()); //this will give currenct thread running name
        System.out.println(t1.getName()); // this will print which number of thread is running
        System.out.println(t2.getName());

        System.out.println(t1.getState());  // TERMINATED
        System.out.println(t2.getState());


    }
}
