package Day5;

public class Mountain {

    public static void main(String[]args){

        String path= "UDDDUUDDUUUD";

        int level=0;
        int Mountain=0;
        int Valley=0;

        for (int i = 0; i < path.length(); i++){

            char ch=path.charAt(i);

            if(level==0 && ch=='U' ){
                Mountain++;

            }
            if(level==0 && ch=='D'){
                Valley++;
            }

            if(ch=='U'){
                level++;
            }
            else if(ch=='D'){
                level--;
            }
        }

        System.out.println("Mountains are :"+ Mountain);
        System.out.println(("Valleys are :"+ Valley));



    }
}
