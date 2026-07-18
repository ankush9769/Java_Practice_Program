package util;

import model.User;
import service.AuthService;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Starter {
    static Scanner sc = new Scanner(System.in);

    public static void signUp()throws SQLException {
        Random random = new Random();
        int accountno = random.nextInt(9999999);

        User user = AuthService.signUp(
                readLine("Account Name:"),
                readLine("email:"),
                readLine("password:"),
                branchoic(),
                accountno);
        System.out.println("user registered with id:"+user.getId());
    }
    public static void signIn()throws SQLException{
        User user = AuthService.signIn(
                readLine("email: "),
                readLine("password: ")
        );
        if(user == null){
            System.out.println("No user found");
            return;
        }

        System.out.println("user login successfully with id:"+user.getId());
        userMenu(user);

    }
    public static void start() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("!! well come to Banking System Application !!");
        while(true){
            System.out.println("1. sign up");
            System.out.println("2. sign in");
            System.out.println("0. exit");
            int choice = sc.nextInt();

            switch (choice){
                case 1 ->signUp();
                case 2 ->signIn();
                case 0 -> {
                    return;
                }
                default -> System.out.println("invalid input");
            }

        }

    }
    public static String readLine(String label){
        System.out.print(label);
        return sc.nextLine();
    }
    public static String branchoic(){
        System.out.println("select banch");
        System.out.println("1. dadar");
        System.out.println("2. kandivali");
        System.out.println("3. nalasopara");
        int branchint = sc.nextInt();
        String branchs = switch (branchint){
            case 1 -> "dadar";
            case 2 ->"kandivali";
            case 3 ->"nalasopara";
            default ->"invalid data";
        };
        return branchs;
    }

    public static void userMenu(User user) throws SQLException {
        while(true){
            System.out.println("1. Deposit");
            System.out.println("2. withdraw");
            System.out.println("3. My profile");
            System.out.println("4. chech balance");
            System.out.println("5. transaction history");
            System.out.println("0. logout");
            int choice = sc.nextInt();
            switch (choice){
                case 1 ->{deposit(user.getId());}
                case 2 ->{}
                case 3 ->{}
                case 4 ->{}
                case 5 ->{}
                case 0 -> {
                    return;
                }
                default -> System.out.println("invalid inpute");
            }

        }
    }
    public static void deposit(int id)throws SQLException{
        System.out.println("deposit amount:");
        double depositamount = sc.nextDouble();
//        User user = AuthService.deposit(depositamount,id);
    }
}
