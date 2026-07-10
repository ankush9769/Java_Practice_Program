import java.sql.*;

public class show {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);

        String show_query = "select * from employees";
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
