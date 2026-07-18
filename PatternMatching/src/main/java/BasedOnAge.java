import java.util.Scanner;

public class BasedOnAge extends Exception{
    public BasedOnAge(String str){
        super(str);
    }

    public void marriage(int age) throws BasedOnAge{
        if(age<20){
            throw new BasedOnAge("To Yong to Marry");
        } else if (age>80) {
             throw new BasedOnAge("To Old  to Marry");
        }
        else{
            System.out.println("best age to get marry");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        BasedOnAge obj = new BasedOnAge("Age Exception");
        try {
            obj.marriage(age);
        }
        catch (BasedOnAge e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }

}
