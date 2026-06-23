package Day5;

public class Cloud {

    public static void main(String[] args) {

        int arr[] = {0, 1, 0, 0, 1, 0, 1, 0};
        int jumps = 0;
        int i = 0;
        while (i < arr.length - 1)
        {
            if (i + 2 < arr.length && arr[i + 2] == 0) {
                i = i + 2;
            } else {
                i = i + 1;
            }
            jumps++;
        }
        System.out.println("Jumps = " + jumps);
    }
}