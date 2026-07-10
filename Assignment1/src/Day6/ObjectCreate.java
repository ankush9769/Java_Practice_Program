package Day6;

public class ObjectCreate {

    static int count = 0;

    String name;
    int age;

    ObjectCreate(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public static void main(String[] args) {

        ObjectCreate o1 = new ObjectCreate("Rohit", 23);
        ObjectCreate o2 = new ObjectCreate("Amit", 25);
        ObjectCreate o3 = new ObjectCreate("Prajwal", 43);
        ObjectCreate o4 = new ObjectCreate("Raj", 33);

        System.out.println("Count of Objects = " + ObjectCreate.count);
    }
}