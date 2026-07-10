package Callable;

import JDBC.JDBCconn;

import java.sql.*;

public class GetSalById {
    public static void main(String[] args) throws Exception {
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
//        String user = "root";
//        String pwd = "";
//
//        Class.forName(driver);
//        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);


        Connection con =  JDBCconn.connect();

        CallableStatement callst = con.prepareCall("{call getsalary(?,?)}");
        callst.setInt(1,102);
        callst.registerOutParameter(2,Types.DOUBLE);
        callst.execute();
        System.out.println(callst.getInt(2));
    }
}
