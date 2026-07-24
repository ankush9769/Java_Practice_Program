package org.example.atomic;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntranct {
    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void randomMethod(){
        reentrantLock.lock();
        try {
            System.out.println(reentrantLock.getHoldCount());
        } finally {
            System.out.println(reentrantLock.getHoldCount()+"unlock");
            reentrantLock.unlock();
        }

    }
    static void main() {
        reentrantLock.lock();
        try {
            System.out.println(reentrantLock.getHoldCount());
            randomMethod();

        } finally {
            System.out.println(reentrantLock.getHoldCount()+"unlock");
            reentrantLock.unlock();
        }
    }
}
