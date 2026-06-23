package classwork;

import java.util.Arrays;

public class MountainValley {
    public static void main(String[] args){
        String path = "UDDDUUUDDDDUUU";
        String[] arr = path.split("");
        int mountain =0;
        int valley =0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("U")){
                count++;
            }else{
                count--;
            }
            if(count==0){
                if(arr[i].equals("D")){
                    mountain++;
                }else{
                    valley++;
                }
            }
        }
        System.out.println("no. of mountain ="+mountain);
        System.out.println("no. of valley ="+valley);
    }
}
