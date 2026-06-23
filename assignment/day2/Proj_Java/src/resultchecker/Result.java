package resultchecker;

import java.util.Scanner;

public class Result {
    public int total(int maths,int science,int english,int marathi,int hindi){
        return (maths+science+english+marathi+hindi);
    }
    public int average(int total){
        return (total/5);
    }
    public char grade(int average){
        if(average>90 && average<=100){
            return 'A';
        } else if (average>80 && average<=90) {
            return 'B';
        } else if (average>70 && average<=80) {
            return 'C';
        } else if (average>60 && average<=70) {
            return 'D';
        } else if (average>50 && average<=60) {
            return 'E';
        }else{
            return 'F';
        }
    }
    public boolean isPass(int maths,int science,int english,int marathi,int hindi){
        if(maths>50 && science>50 && english>50 && marathi>50 && hindi>50){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("enter 5 subject marsk");
        System.out.println("enter you maths subject marks");
        int maths = sc.nextInt();
        System.out.println("enter you science subject marks");
        int science = sc.nextInt();
        System.out.println("enter you english subject marks");
        int english = sc.nextInt();
        System.out.println("enter you marathi subject marks");
        int marathi = sc.nextInt();
        System.out.println("enter you hindi subject marks");
        int hindi = sc.nextInt();

        Result r = new Result();
        int total = r.total(maths,science,english,marathi,hindi);
        System.out.println("your total marks is = "+total);

        int average = r.average(total);
        System.out.println("your average marks is ="+average);

        char grade= r.grade(average);
        System.out.println("your grade is = "+grade);

        boolean ispass = r.isPass(maths,science,english,marathi,hindi);
        if(ispass){
            System.out.println("student is pass");
        }else{
            System.out.println("student is fail");
        }










    }
}
