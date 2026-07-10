package Day5;

public class Diagonal {

    public static void main (String[] args){

        int arr [] []={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int firstsum=0;
        int secondsum=0;

        for (int i=0;i<arr.length;i++){
            firstsum += arr[i][i];
            secondsum += arr[i][arr.length - 1 - i];
        }
        System.out.println("Primary Diagonal Sum = " + firstsum);
        System.out.println("Secondary Diagonal Sum = " + secondsum);
    }
}
