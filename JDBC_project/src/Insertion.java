import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static java.time.chrono.JapaneseEra.values;

public class Insertion {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
//        String insert_query = "insert into employees(eno,ename,esal,eaddr) " +
//                "values(103,'shreya',50000,'naalsopara')";
        Statement st = con.createStatement();
//        int rows = st.executeUpdate(insert_query);
//        System.out.println("no. of rows affected ="+rows);


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

            String multiple_insert = String.format("insert into employees values(%d,'%s',%f,'%s')",id,name,sal,addr);
            st.executeUpdate(multiple_insert);
            rows++;



            System.out.println("do you want to add more record");
            ask = sc.next().charAt(0);
        }
        System.out.println("no. of rows affected ="+rows);
        System.out.println("thank you");


    }
}
