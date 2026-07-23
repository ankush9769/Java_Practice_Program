package dao;

import config.DatabaseConnection;
import model.Type;
import model.User;

import java.sql.*;
import java.time.LocalDate;

public class UserDao {
    public static User createUser(String name,String email,int accountno,String ifsc ,String branch,String password)throws SQLException {
        String sql = "insert into user(name,email,accountno,ifsc,branch,password) values(?,?,?,?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS))
        {
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setInt(3,accountno);
            statement.setString(4,ifsc);
            statement.setString(5,branch);
            statement.setString(6,password);

            statement.executeUpdate();
            try(ResultSet keys = statement.getGeneratedKeys())
            {
                keys.next();
                User user = findById(keys.getInt(1));
                if(user == null){
                    throw new SQLException("failed to load newly created user");
                }
                return user;
            }

        }
    }
    //in up del
    public static User findById(int id)throws SQLException
    {
        String sql = "select * from User where id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1,id);
            try(ResultSet resultSet = statement.executeQuery())
            {
                return resultSet.next() ? map(resultSet) : null;  //map is not built in method
            }
        }
    }
    private static User map(ResultSet resultSet) throws SQLException
    {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getInt("accountno"),
                resultSet.getString("ifsc"),
                resultSet.getString("branch"),
                resultSet.getString("role"),
                resultSet.getDouble("balance")
        );
    }
    public static User findByEmailAndPassword(String email,String password) throws SQLException
    {
        String sql = "select * from user where email = ? AND password = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1,email);
            statement.setString(2,password);
            try(ResultSet resultSet= statement.executeQuery()){
                return resultSet.next() ? map(resultSet) : null;
            }
        }
    }
    public static boolean depositAmount(double amount,int id)throws SQLException{
        String sql = "update user set balance = balance+? where id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS))
        {
            statement.setDouble(1,amount);
            statement.setInt(2,id);
            return statement.executeUpdate()==1;
        }
    }
    public static boolean withdrawAmount(double amount,int id)throws SQLException{
        final double limitamount = 80000;
        String sql2 = "select sum(amount) as sumamount from transaction where userid = ? AND type = ? AND DATE(time) = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql2))
        {
            statement.setInt(1,id);
            statement.setString(2,Type.WITHDRAW.name());
            statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                double sumamount = resultSet.getDouble("sumamount");
                if (resultSet.wasNull()) {
                    sumamount = 0;
                }
                if (sumamount + amount <= limitamount){
                    String sql = "update user set balance = balance-? where id = ?";
                    try(PreparedStatement statement2 = connection.prepareStatement(sql))
                    {
                        statement2.setDouble(1,amount);
                        statement2.setInt(2,id);
                        return statement2.executeUpdate()==1;
                    }
                }else{
                    System.out.println("you hitt the daily limit 50000");
                    return false;
                }
            }
        }
        return false;
    }
    public static double checkBalance(int id)throws SQLException{
        String sql = "select balance from user where id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return resultSet.getDouble("balance");
            }else{
                throw new SQLException("User not found");
            }

        }
    }
    public static boolean verifyPassword(int id,String password) throws SQLException
    {
        String sql = "select password from user where id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String storedpassword = resultSet.getString("password");
//                System.out.println("Stored : " + storedpassword);
//                System.out.println("Entered: " + password);
//                System.out.println(storedpassword.equals(password));
                return storedpassword.equals(password);
            }
            return false;
        }
    }
    public static boolean resetPassword(int id,String password)throws SQLException{
        String sql = "update user set password= ? where id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,password);
            statement.setInt(2,id);
            return statement.executeUpdate()==1;
        }
    }
}
