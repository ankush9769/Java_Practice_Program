package org.example.deadLock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorFramwork {
    static void main() {
        Executor executor = Executors.newSingleThreadExecutor() ;
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        }
    }


