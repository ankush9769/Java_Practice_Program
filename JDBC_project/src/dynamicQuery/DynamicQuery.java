package dynamicQuery;

import java.sql.*;
import java.util.Scanner;

public class DynamicQuery {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/ankush_jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(jdbc_url,user,pwd);

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the valid sql query");
        String query = sc.nextLine();

        Statement st = con.createStatement();
        boolean bool = st.execute(query);

        if(bool){
            ResultSet rs = st.getResultSet();
            while (rs.next()){
                System.out.println(rs.getInt(1)+".."
                        +rs.getString(2)+".."+
                        rs.getDouble(3)+".."+
                        rs.getString(4));
            }
        }else{
            int rows = st.getUpdateCount();
            System.out.println(rows+" no. of rows affected");
        }

//        Executequery() = which is specifically used for select statements and getting resultset
//        Executeupdate() query which is used specifically in the update statement.Which only returns the number of rows affected
//        Execute() which is specifically used when we don't know which type of statement the user is going to pass, whether it's only execution or a selecting query or the update.


//        life cycle of sql query execution
//        for any type of query database ingine will perform some set of activities
//        1) compilation
//                i) query tocanization in this step the sql query will be devided into number of tokens and
//                    and generate a stream of token as output
//                ii) query parsing in this step database engine will create parse tree(query tree) with stream
//                    of token if the query tree is proper then there is no syntatical mistake in that query
//                    if the query tree construciton fails it indecates that there are some syntactical error in
//                    that query and sql exception will raised
//                iii) query optimizaion  = the main perpose of the queyr optimizaion is to improve performance and
//                     in this step an optimized query tree will be generated
//        2) execution = once the compilation  succeds then the database engine will take that query tree as inpute and e
//                   execute that query by using interpretor
//        3) Fetch Result (resultset) = db enginge will provide the result of the sql query  either in the fomr of the
//                   result set (for select query) or in the form of row count(for non select query)


//        need of prepare statement
//                in case of normal statement when ever we are executiing an sql query every time compilation
//                and execution will happend at db side some time in our applicaion we requirs to execute
//                same query multiple time for same or different inpute
//                eg... listing out train between same source and destination
//                in this case the statement query will executed laks of time per day to overcome this problem
//               we should go for preparestatement may advantage of preparestatement is the query will be
//                compile only once eventhough we executing multiple time so overall performace of an
//                application will improve
    }
}
