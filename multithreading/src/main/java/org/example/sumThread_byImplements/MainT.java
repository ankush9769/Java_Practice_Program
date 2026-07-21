package org.example.sumThread_byImplements;

public class MainT {
    static void main() throws InterruptedException {
        ChildTSum ct = new ChildTSum();
        Thread t1 = new Thread(ct);
        t1.start();
        Thread.sleep(2000);  //so that till that time main thread get the the value of the sum
//        t1.join();   // Wait for child thread to finish
        System.out.println(ChildTSum.sum);
    }
}
