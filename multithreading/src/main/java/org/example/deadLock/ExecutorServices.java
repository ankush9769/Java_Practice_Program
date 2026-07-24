package org.example.deadLock;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExecutorServices {
    static void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i=1;i<=100;i++)
        {
            int orderId=i;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+" processing order : "+orderId);
            });
        }
    }

}
