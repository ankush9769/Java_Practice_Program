package service;

import dao.UserDao;
import model.User;
import util.PasswordUtil;

import java.sql.SQLException;

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
}
