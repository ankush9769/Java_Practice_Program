package service;

import dao.AdminDao;
import dao.TransactionDao;
import dao.UserDao;
import model.Transaction;
import model.Type;
import model.User;
import util.PasswordUtil;

import java.sql.SQLException;
import java.util.List;

public class AuthService {
    private final UserDao userDao;

    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public static User signUp(String name,String email,String password,String branch,int accountno)throws SQLException {
        String ifsc;
        if(branch.equals("dadar")){
            ifsc = "dadar12345";
        } else if (branch.equals("kandivali")) {
            ifsc = "kandivali12345";
        }else{
            ifsc = "nalasopara12345";
        }
        return UserDao.createUser(name,email,accountno,ifsc,branch, PasswordUtil.hash(password));
    }
    public static User signIn(String email,String password)throws SQLException{
        return UserDao.findByEmailAndPassword(email,PasswordUtil.hash(password));
    }

    public static boolean deposit(double amount,int id)throws SQLException{
        return UserDao.depositAmount(amount,id);
    }
    public static boolean withdraw(double amount,int id)throws SQLException{
        return UserDao.withdrawAmount(amount,id);
    }
    public static double checkBalance(int id)throws SQLException{
        return UserDao.checkBalance(id);
    }
    public static List<User> findAllUsers() throws SQLException {
        return AdminDao.findAllUsers();
    }
    public static List<Transaction> findTransactions() throws SQLException {
        return AdminDao.findAllTransactions();
    }
    public static List<Transaction> transactionHistory(int id) throws SQLException {
        return TransactionDao.transactionHistory(id);
    }
    public static boolean verifyPassword(int id,String password)throws SQLException{
        return UserDao.verifyPassword(id,PasswordUtil.hash(password));
    }
    public static boolean resetPassword(int id,String password)throws SQLException{
        return UserDao.resetPassword(id,PasswordUtil.hash(password));
    }
    public static List<Transaction> miniStatement(int id,int statechoice)throws SQLException{
        String type;
        if (statechoice == 1) {
            type = Type.DEPOSIT.name();
        } else if (statechoice == 2) {
            type = Type.WITHDRAW.name();
        } else {
            System.out.println("invalid input");
            return null;
        }
        return TransactionDao.miniStatement(id,type);
    }


}
