package org.example.sumThread_byExtends;

public class MainThread {
    static void main() {
        ChildThreadSum ct1 = new ChildThreadSum();
        System.out.println("before thread");
        ct1.start();
        System.out.println("thread is running");
        System.out.println(ChildThreadSum.sum);
        System.out.println("thread ends");
    }
}
