package Day5;

class Addition {

    void add(int... numbers) {
        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum = " + sum);
    }
    public static void main(String[] args) {

        Addition obj = new Addition();
        obj.add(10, 20);
        obj.add(1, 2, 3);
        obj.add(3, 5, 7, 6);
        obj.add(5,6,66,89);
    }
}
