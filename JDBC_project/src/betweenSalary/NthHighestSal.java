package betweenSalary;

import java.sql.*;
import java.util.Scanner;

public class NthHighestSal {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);

        Scanner sc = new Scanner(System.in);
        System.out.println("enter input for the Nth highest sal");
        int n = sc.nextInt();

        String show_query = "select * from employees order by esal desc limit "+(n-1)+","+1;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(show_query);

        while (rs.next()){
            System.out.println(rs.getInt(1)+".."
                    +rs.getString(2)+".."+
                    rs.getDouble(3)+".."+
                    rs.getString(4));
        }
    }
}
