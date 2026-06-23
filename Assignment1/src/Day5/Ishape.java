package Day5;

public class Ishape {

    public static void main(String[] args) {

        int arr[][] = {
                {1, 2, 3, 4, 5},
                {0, 6, 0, 7, 0},
                {8, 9, 1, 2, 3},
                {0, 4, 0, 5, 0},
                {6, 7, 8, 9, 1}
        };

        int max = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                int sum = 0;

                sum = sum + arr[i][j];
                sum = sum + arr[i][j + 1];
                sum = sum + arr[i][j + 2];

                sum = sum + arr[i + 1][j + 1];

                sum = sum + arr[i + 2][j];
                sum = sum + arr[i + 2][j + 1];
                sum = sum + arr[i + 2][j + 2];

                System.out.println("I Shape Sum = " + sum);

                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println("Maximum I Shape Sum = " + max);
    }
}