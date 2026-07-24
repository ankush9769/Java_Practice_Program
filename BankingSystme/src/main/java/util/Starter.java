package util;

import dao.TransactionDao;
import model.Status;
import model.Transaction;
import model.Type;
import model.User;
import service.AuthService;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Starter {
    static Scanner sc = new Scanner(System.in);

    public static String readLine(String label){
        System.out.print(label);
        return sc.nextLine();
    }
    private static int readInt(String label) {
        System.out.print(label);
        return Integer.parseInt(sc.nextLine());
    }
    private static double readDouble(String label) {
        System.out.print(label);
        return Double.parseDouble(sc.nextLine());
    }

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
        if(user.getRole().equals("admin")){
            adminMenu(user);
            return;
        }
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




    public static void adminMenu(User users){

        try {
            while (true){
                System.out.println("You are logged in into the account");
                System.out.println("Press 1. view all Users");
                System.out.println("press 2. view all transactions ");
                System.out.println("press 3. view all failed transaction");
                System.out.println("press 4. view highest balance user");
                System.out.println("press 5. view transactions between selected dates");
                System.out.println("Press 0 for logout");
                int choice = readInt("Choice: ");

                switch (choice){
                    case 1->viewUsers();
                    case 2-> viewAllTransactions();
                    case 3-> viewAllFailTransaction();
                    case 4-> highestBalanceUser();
                    case 5 ->transactionBetweenDate();
                    case 0 -> {return;}
                    default -> System.out.println("Invalid Option");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void viewUsers() throws SQLException {
        AuthService.findAllUsers().forEach(user ->
                System.out.printf(
                        "Id=%d, Name=%s, Email=%s, Account No=%d, Branch=%s, IFSC=%s, Balance=%.2f%n",
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getAccountno(),
                        user.getBranch(),
                        user.getIfsc(),
                        user.getBalance()
                )
        );
    }
    private static void viewAllTransactions() throws SQLException {
        AuthService.findTransactions().forEach(transaction ->
                System.out.printf(
                        "User Id=%d, Type=%s, Amount=%.2f, Balance After=%.2f, Status=%s, Reason=%s%n",
                        transaction.getUserid(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getBalanceafter(),
                        transaction.getStatus(),
                        transaction.getReason()
                )
        );
    }
    private static void viewAllFailTransaction() throws SQLException{
        AuthService.AllfailTransaction().forEach(transaction ->
                System.out.printf(
                        "User Id=%d, Type=%s, Amount=%.2f, Balance After=%.2f, Status=%s, Reason=%s%n",
                        transaction.getUserid(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getBalanceafter(),
                        transaction.getStatus(),
                        transaction.getReason()
                )
        );
    }
    private static void highestBalanceUser() throws SQLException {
        AuthService.highestBalanceUser().forEach(user ->
                System.out.printf(
                        "Id=%d, Name=%s, Email=%s, Account No=%d, Branch=%s, IFSC=%s, Balance=%.2f%n",
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getAccountno(),
                        user.getBranch(),
                        user.getIfsc(),
                        user.getBalance()
                )
        );
    }
    private static void transactionBetweenDate() throws SQLException{
        AuthService.transactionBetweenDate(readLine("enter start date"),readLine("enter end date")).forEach(transaction ->
                System.out.printf(
                        "User Id=%d, Type=%s, Amount=%.2f, Balance After=%.2f, Status=%s, Reason=%s%n",
                        transaction.getUserid(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getBalanceafter(),
                        transaction.getStatus(),
                        transaction.getReason()
                )
        );
    }









    public static void userMenu(User user) throws SQLException {
        while(true){
            System.out.println("1. Deposit");
            System.out.println("2. withdraw");
            System.out.println("3. My profile");
            System.out.println("4. chech balance");
            System.out.println("5. transaction history");
            System.out.println("6. resetPassword");
            System.out.println("7. miniStatement");
            System.out.println("0. logout");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 ->{deposit(user.getId(),user);}
                case 2 ->{withdraw(user.getId(),user);}
                case 3 ->{myProfile(user);}
                case 4 ->{double bal =checkBalance(user.getId());
                    System.out.println("balance ="+bal);}
                case 5 ->{transactionHistory(user);}
                case 6 ->{resetPassword(user);}
                case 7 ->{miniStatement(user);}
                case 0 -> {
                    return;
                }
                default -> System.out.println("invalid inpute");
            }

        }
    }
    public static void deposit(int id,User user)throws SQLException{
        System.out.println("deposit amount:");
        double depositamount = sc.nextDouble();
        if(depositamount>0){
            boolean isdeposit = AuthService.deposit(depositamount,id);
            if(isdeposit){
                System.out.println("deposite amount successfuly ");
                Transaction transaction = new Transaction(
                        user.getId(),
                        Type.DEPOSIT,
                        depositamount,
                        user.getBalance(),
                        Status.SUCCESSFUL,
                        "deposite done"
                );
                TransactionDao.create(transaction);
            }else{
                System.out.println("failed to deposit");
            }
        }else{
            System.out.println("enter +ve amount");
        }

    }
    public static void withdraw(int id,User user)throws SQLException{
        System.out.println("withdraw amount:");
        double withdrawamount = sc.nextDouble();
        if(withdrawamount>0){
            double finalbalance = checkBalance(id);
            if(withdrawamount<finalbalance){
                boolean iswithdraw = AuthService.withdraw(withdrawamount,id);
                if(iswithdraw){
                    System.out.println("withdraw amount successfuly ");
                    Transaction transaction = new Transaction(
                            user.getId(),
                            Type.WITHDRAW,
                            withdrawamount,
                            user.getBalance(),
                            Status.SUCCESSFUL,
                            "withdraw done"
                    );
                    TransactionDao.create(transaction);
                }else{
                    System.out.println("failed to withdraw");
                    Transaction transaction = new Transaction(
                            user.getId(),
                            Type.WITHDRAW,
                            withdrawamount,
                            user.getBalance(),
                            Status.FAILED,
                            "hitt the daily limit"
                    );
                    TransactionDao.create(transaction);
                }
            }else{
                System.out.println("sorry !!! dont have sufficient amount");
                Transaction transaction = new Transaction(
                        user.getId(),
                        Type.WITHDRAW,
                        withdrawamount,
                        user.getBalance(),
                        Status.FAILED,
                        "sufficient amount"
                );
                TransactionDao.create(transaction);
            }
        }
        else{
            System.out.println("enter +ve amount");
        }
    }
    public static double checkBalance(int id)throws SQLException{
        double balance = AuthService.checkBalance(id);
        return balance;
    }
    public static void myProfile(User user)throws SQLException{
        System.out.println("id:"+user.getId());
        System.out.println("name:"+user.getName());
        System.out.println("email:"+user.getEmail());
        System.out.println("Account no.:"+user.getAccountno());
        System.out.println("IFSC :" + user.getIfsc());
        System.out.println("Branch :" + user.getBranch());
        System.out.println("Role :" + user.getRole());
        System.out.println("Balance :" + user.getBalance());
    }
    private static void transactionHistory(User user) throws SQLException {
        List<Transaction> transactions = AuthService.transactionHistory(user.getId());
        for (Transaction transaction : transactions) {
            System.out.println("Type : " + transaction.getType());
            System.out.println("Amount : " + transaction.getAmount());
            System.out.println("Status : " + transaction.getStatus());
            System.out.println("Reason : " + transaction.getReason());
        }
    }
    public static void resetPassword(User user) throws SQLException {
        boolean isverify = AuthService.verifyPassword(user.getId(),readLine("enter password for verification: "));
        if(isverify){
            String newpassword = readLine("enter the new password ...." +
                    "which follows following rules" +
                    " minimum 8 characters, one digit, one uppercase letter.:");

            boolean isUpper = false;
            boolean islower = false;
            boolean isDigit = false;

            for (char ch : newpassword.toCharArray()) {
                if (Character.isUpperCase(ch)){
                    isUpper = true;
                }
                if (Character.isLowerCase(ch)) {
                    islower = true;
                }
                if (Character.isDigit(ch)){
                    isDigit=true;
                }
            }

            if (newpassword.length() >= 8 && isUpper && islower && isDigit) {
                boolean isresetpassword = AuthService.resetPassword(user.getId(),newpassword);
                if(isresetpassword){
                    System.out.println("password updated successfully");
                }else{
                    System.out.println("sorry !!! password couldn't update");
                }
            } else {
                System.out.println("password validation failed.");
            }
        }else{
            System.out.println("your password does not matched");
        }
    }
    public  static void miniStatement(User user) throws SQLException {
        System.out.println("on what basis you want miniStatments");
        System.out.println("press 1. DEPOSIT");
        System.out.println("press 2. WITHDRAW");
        int statechoice = sc.nextInt();
        List<Transaction> transactions = AuthService.miniStatement(user.getId(),statechoice);
        for (Transaction transaction : transactions) {
            System.out.println("Type : " + transaction.getType());
            System.out.println("Amount : " + transaction.getAmount());
            System.out.println("Status : " + transaction.getStatus());
            System.out.println("Reason : " + transaction.getReason());
        }


    }
}
