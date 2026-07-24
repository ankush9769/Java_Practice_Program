package org.example.atomic;
import java.util.concurrent.atomic.AtomicInteger;
public class AtomicIntegers {
    static AtomicInteger count=new AtomicInteger();
    static void main() throws InterruptedException {
        Runnable task=()->{
            for(int i=0;i<10000;i++){
//                count++;
                count.incrementAndGet();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }


}
