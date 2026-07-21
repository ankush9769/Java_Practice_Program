package dao;

import config.DatabaseConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
