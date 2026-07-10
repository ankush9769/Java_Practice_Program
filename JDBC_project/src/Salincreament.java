import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Salincreament {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);

        Statement st = con.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the salary for condition");
        double con_sal = sc.nextDouble();
        System.out.println("enter the increment");
        double inc_sal = sc.nextDouble();

        String update_query = String.format("update employees set esal = esal+%f where esal>%f",inc_sal,con_sal);
        st.executeUpdate(update_query);
        System.out.println("salary increment jhalee succefully");
    }
}
