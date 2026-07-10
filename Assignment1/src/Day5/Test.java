package Day5;

interface Demo {

    void show();

    default void display() {
        System.out.println("This is a default method.");
    }

    static void message() {
        System.out.println("This is a static method.");
    }
}


class Test implements Demo {

    @Override
    public void show() {
        System.out.println("This is an abstract method.");
    }
    public static void main(String[] args) {
        Test obj = new Test();
        obj.show();
        obj.display();
        Demo.message();
    }
}
