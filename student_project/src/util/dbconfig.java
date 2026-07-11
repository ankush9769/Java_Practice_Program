package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
    public static Connection connect() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
        return con;
    }
}
