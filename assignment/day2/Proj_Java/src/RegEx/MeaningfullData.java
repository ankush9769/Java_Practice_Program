package RegEx;

public class MeaningfullData {
    public static void main(String[] args){
        String url = "www.example.com?id=101&name=xyz&salary=1000&dept=software developer";
        String meaningURL = url.substring(16);
        String[] arr = meaningURL.split("&");
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
