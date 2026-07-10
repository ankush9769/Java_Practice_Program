package Day5;

class Demo1 {

    Demo1(int a) {
        System.out.println("Parent constructor: " + a);
    }
}

class A extends Demo1 {

    A() {
        super(10);
        System.out.println("Child constructor");
    }

    public static void main(String[] args) {
        A obj = new A();
    }
}
