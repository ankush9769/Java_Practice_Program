package RegEx;

import java.util.Arrays;

public class FindVersion {
    public static void main(String[] args){
        String version1 = "12.1.10";
        String version2 = "12.1.12";
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        for(int i =0 ;i < arr1.length;i++){
            if(!arr1[i].equals(arr2[i])){
                if(Integer.parseInt(arr1[i])>Integer.parseInt(arr2[i])){
                    System.out.println(Arrays.toString(arr1));
                }else{
                    System.out.println(Arrays.toString(arr2));
                }
            }
        }
    }
}
