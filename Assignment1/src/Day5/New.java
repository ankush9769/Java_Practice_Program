package Day5;

@FunctionalInterface
interface Greeting {
    void display();
}
public class New {

    public static void main(String[] args) {

        Greeting g = () -> {
            System.out.println("Hello from Lambda Expression");
        };

        g.display();
    }
}