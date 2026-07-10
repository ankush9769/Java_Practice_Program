package betweenSalary;

import java.sql.*;
import java.util.Scanner;

public class BetweenRangeSal {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);

        Scanner sc = new Scanner(System.in);
        System.out.println("enter min salary");
        double min = sc.nextDouble();
        System.out.println("enter max salary");
        double max = sc.nextDouble();

        String show_query = String.format("select * from employees where esal BETWEEN %f AND %f",min,max);
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
