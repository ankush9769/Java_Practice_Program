package org.example.deadLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorMethodEmplimentor {
    static void main() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=1;i<=100;i++)
        {
            int orderId=i;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+" processing order : "+orderId);
            });
        }


//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        ScheduledExecutorService executorService3 = Executors.newScheduledThreadPool(1);
//        executorService3.schedule(()->{
//            System.out.println("Thread is running");
//        },5, TimeUnit.SECONDS);
        ScheduledExecutorService executorService3 = Executors.newScheduledThreadPool(1);
        executorService3.scheduleAtFixedRate(()->{
            System.out.println("Thread is running");
        },0,1, TimeUnit.SECONDS);




    }
}
