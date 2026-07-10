import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc1 {
    public static void main(String[] args) throws Exception{
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);

        String query = "create table employees(eno int,ename varchar(100),esal double,eaddr varchar(100))";
        Statement st = con.createStatement();
        st.executeUpdate(query);
        //execute() executeQueruy()
        //st.executeQuery() //ResultSet
        System.out.println("table created successfully");

        con.close();
    }
}
