package array;

public class MaxMin {
    public static void main(String[] args){
        int[] arr = {3,6,5,2,8,7,9};
        int max=arr[0];
        int min=arr[0];
        int secondmax=arr[0];
        int secondmin=arr[0];

        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                secondmax=max;
                max = arr[i];
            }
            if(arr[i]<min){
                secondmin=min;
                min = arr[i];
            }
        }
        System.out.println("max is = "+max);
        System.out.println("secondmax is = "+secondmax);
        System.out.println("min is = "+min);
        System.out.println("secondmin is = "+secondmin);
    }
}
