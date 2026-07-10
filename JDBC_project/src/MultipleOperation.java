import JDBC.JDBCconn;

import java.sql.Connection;
import java.sql.Statement;

public class MultipleOperation {
    public static void main(String[] args) throws Exception {
        Connection con = JDBCconn.connect();

        Statement st = con.createStatement();
        st.addBatch("insert into employees values(108,'Jatin',60000,'Pune')");
        st.addBatch("update employees set esal =55000 where eno=104");
        st.addBatch("delete from employees where eno=103");

        int[] count= st.executeBatch();
        int sum =0;
        for(int i =0;i<count.length;i++){
            sum+=i;
        }
        System.out.println("this many rows got affected="+sum);

    }
}
