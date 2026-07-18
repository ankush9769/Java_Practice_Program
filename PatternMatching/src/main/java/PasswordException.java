import java.util.Scanner;

public class PasswordException extends Exception{
    public PasswordException(String message){
        super(message);
    }

    public void validatePassword(String password) throws Exception {
        if (password.length() < 10) {
            throw new PasswordException("Password must contain at least 10 characters.");
        }
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper = true;
            }
            else if (Character.isLowerCase(ch)) {
                lower = true;
            }
            else if (Character.isDigit(ch)) {
                digit = true;
            }
            else {
                special = true;
            }
        }

        if(!upper){
            throw  new Exception("Password must contain At least one Upper Character");
        }
        if(!lower){
            throw  new Exception("Password must contain At least one lower Character");
        }
        if(!digit){
            throw  new Exception("Password must contain At least one digit");
        }
        if(!special){
            throw  new Exception("Password must contain At least one Special Character");
        }

        System.out.println("Strong Password");

}
public static  void main(String [] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter Password: ");
    String password = sc.nextLine();

    PasswordException obj = new PasswordException("Invalid Password");
    try {
        obj.validatePassword(password);
    }
    catch (Exception e) {
        System.out.println(e.getMessage());
    }

    sc.close();
}
}
