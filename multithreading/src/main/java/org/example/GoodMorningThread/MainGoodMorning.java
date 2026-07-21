package org.example.GoodMorningThread;

public class MainGoodMorning {
    static void main() {
        GoodMorning gm1 = new GoodMorning();
        ChildThreadWish c1 = new ChildThreadWish(gm1,"ankush");
        ChildThreadWish c2 = new ChildThreadWish(gm1,"shreya");

        c1.start();
        c2.start();
    }
}
