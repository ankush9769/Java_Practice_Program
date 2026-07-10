package Callable;

import JDBC.JDBCconn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

public class EmailVerify {
    public static void main(String[] args) throws Exception {
        Connection con = JDBCconn.connect();

        Scanner sc = new Scanner(System.in);
        System.out.println("enter your email =");
        String email = sc.next();
        System.out.println("enter your password =");
        String pass = sc.next();

        CallableStatement callst = con.prepareCall("{call verification(?,?,?)}");
        callst.setString(1,email);
        callst.setString(2,pass);
        callst.registerOutParameter(3, Types.BOOLEAN);
        callst.execute();

        boolean isverify = callst.getBoolean(3);
        if(isverify){
            System.out.println("you email and password matched successfully");
            System.out.println("login successfully");
        }else{
            System.out.println("sorry !!!...email and password not matched");
        }

    }
}
