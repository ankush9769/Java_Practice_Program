package Day6;

public class Time {

    static int count = 0;
    {
        count++;
        System.out.println("SIB");
    }
    Time() {

        System.out.println("Default Constructor");
    }

    Time(int a, int b) {

        System.out.println("Sum is: " + (a + b));
    }

    Time(String name, int age) {

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(3, 4);
        Time t3 = new Time("ROHIT", 23);
        Time t4 =new Time("prajwal",34);
        System.out.println("Total Objects Created = " + Time.count);
    }
}