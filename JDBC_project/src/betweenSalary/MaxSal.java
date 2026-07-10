package betweenSalary;

import java.sql.*;

public class MaxSal {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);

        String show_query = "select max(esal) from employees ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(show_query);

        if(rs.next()){
            System.out.println(rs.getInt(1));
        }
    }
}
