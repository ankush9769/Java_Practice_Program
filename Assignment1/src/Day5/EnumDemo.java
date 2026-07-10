package Day5;

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

public class EnumDemo {

    public static void main(String[] args) {

        Day d = Day.TUESDAY;

        System.out.println(d);
    }
}