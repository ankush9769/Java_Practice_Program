package PrepareStatment;

import java.sql.*;
import java.util.Scanner;

public class PreInsert {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);

        int rows=0;
        char ask='Y';
        while(ask=='Y'){
            Scanner sc = new Scanner(System.in);
            System.out.println("enter number=");
            int id = sc.nextInt();
            System.out.println("enter name=");
            String name = sc.next();
            System.out.println("enter salary=");
            double sal = sc.nextDouble();
            System.out.println("enter address");
            String addr = sc.next();

            PreparedStatement ps = con.prepareStatement("insert into employees values(?,?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setDouble(3,sal);
            ps.setString(4,addr);
            ps.executeUpdate();
            rows++;

            System.out.println("do you want to add more record");
            ask = sc.next().charAt(0);
        }
        System.out.println("no. of rows affected ="+rows);
        System.out.println("thank you");

    }
}
