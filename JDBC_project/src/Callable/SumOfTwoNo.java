package Callable;

import java.sql.*;

public class SumOfTwoNo {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);


        CallableStatement callst = con.prepareCall("{call AddTwoNum(?,?,?)}");
        callst.setInt(1,100);
        callst.setInt(2,200);
        callst.registerOutParameter(3,Types.INTEGER);
        callst.execute();
        System.out.println(callst.getInt(3));

    }
}
