package array;

public class Primelement {
    public static void isprime(int[] arr){
        for(int i=0;i<arr.length;i++){
            boolean prime = true;
            for(int j=2;j<arr[i];j++){
                if(arr[i]%j==0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                System.out.println(arr[i]+" is prime number");
            }
        }
    }
    public static void sumofprime(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            boolean prime = true;
            for(int j=2;j<arr[i];j++){
                if(arr[i]%j==0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                sum = sum + arr[i];

            }
        }
        System.out.println("sum of prime element of the arr = "+sum);
    }
    public static void main(String[] args){
        int[] arr= {10,11,12,13,14,15};
        isprime(arr);
        sumofprime(arr);
    }
}
