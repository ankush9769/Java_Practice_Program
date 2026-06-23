package classwork;

public class HourGlass {
    public static void main(String[] args){
        int[][] arr = {{1,3,4,5},
                       {7,9,8,1},
                       {6,4,3,2},
                       {2,5,8,7}};
        int g1 =0;
        int g2 =0;
        int g3 =0;
        int g4 =0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                int a;
                int b;
                if((i==1 && j==1)){
                    a = i-1;
                    b = j-1;
                    for(int m=1;m<=3;m++){
                        g1 = g1+arr[a][b];
                        b++;
                    }
                    a = i+1;
                    b = j-1;
                    for(int m=1;m<=3;m++){
                        g1 = g1+arr[a][b];
                        b++;
                    }
                    g1 = g1 + arr[i][j];
                }
                if((i==2 && j==2)){
                    a = i-1;
                    b = j-1;
                    for(int m=1;m<=3;m++){
                        g4 = g4+arr[a][b];
                        b++;
                    }
                    a = i+1;
                    b = j-1;
                    for(int m=1;m<=3;m++){
                        g4 = g4+arr[a][b];
                        b++;
                    }
                    g4 = g4 + arr[i][j];
                }if((i==1 && j==2)){
                    a = i-1;
                    b = j-1;
                    for(int m=1;m<=3;m++){
                        g2 = g2+arr[a][b];
                        b++;
                    }
                    a = i+1;
                    b = j-1;
                    for(int m=1;m<=3;m++){
                        g2 = g2+arr[a][b];
                        b++;
                    }
                    g2 = g2 + arr[i][j];

                }if((i==2 && j==1)){
                    a = i-1;
                    b = j-1;
                    for(int m=1;m<=3;m++){
                        g3 = g3+arr[a][b];
                        b++;
                    }
                    a = i+1;
                    b = j-1;
                    for(int m=1;m<=3;m++){
                        g3 = g3+arr[a][b];
                        b++;
                    }
                    g3 = g3 + arr[i][j];

                }
            }
        }
        System.out.println("sum of g1 ="+g1);
        System.out.println("sum of g2 ="+g2);
        System.out.println("sum of g3 ="+g3);
        System.out.println("sum of g4 ="+g4);
        if((g1>g2)&&(g1>g4)&&(g1>g4)){
            System.out.println("g1 has maximum sum ="+g1);
        }
        if((g2>g1)&&(g2>g3)&&(g2>g4)){
            System.out.println("g2 has maximum sum ="+g2);
        }
        if((g3>g1)&&(g3>g2)&&(g3>g4)){
            System.out.println("g3 has maximum sum ="+g3);
        }
        if((g4>g1)&&(g4>g2)&&(g4>g3)){
            System.out.println("g4 has maximum sum ="+g4);
        }

    }
}
