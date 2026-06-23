package classwork;

public class JumpingCloud {
    public static void main(String[] args){
        int[] arr = {0,1,0,0,1,0,0,0,1,0,0,0};
        int jump =0;
        for(int i=0;i<arr.length;i++){
            if(i<=(arr.length-3)){
            if((arr[i+1]==0)||(arr[i+2]==0)){
                if(arr[i+2]==0){
                    jump++;
                    i=i+1;
                }else{
                    jump++;
                }
            }
            }
        }
        System.out.println("optimize number of jump is ="+jump);
    }
}
