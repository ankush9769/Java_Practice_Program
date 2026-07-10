package Day5;

public class LambdaDemo {

    public static void main(String[] args) {

        // Implementing the interface using a lambda expression
        Demo11 d = () -> {
            System.out.println("Hello from Lambda Expression");
        };

        d.display();

        Demo11 d1 = A1::display;
        d1.display();
    }
}