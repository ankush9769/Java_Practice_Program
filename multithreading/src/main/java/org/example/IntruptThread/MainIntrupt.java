package org.example.IntruptThread;

public class MainIntrupt {
    static void main() {
        ChildIntrupt ci = new ChildIntrupt();
        ci.start();
        ci.interrupt();
    }
}
