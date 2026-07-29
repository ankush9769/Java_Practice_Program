package DAO;

import config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static boolean create(String name ,String email,String hashPassword,String gender,String city){
        String sql = "insert into user(name,email,password,gender,city) values(?,?,?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,hashPassword);
            statement.setString(4,gender);
            statement.setString(5,city);

            if(statement.executeUpdate()==1){
                System.out.println("record added succesffuylly");
                return true;
            }else{
                System.out.println("error in insertion");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static String findByEmailAndPassword(String email,String password) throws SQLException
    {
        String sql = "select * from user where email = ? AND password = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1,email);
            statement.setString(2,password);
            try(ResultSet resultSet= statement.executeQuery()){
                if(resultSet.next()){
                    System.out.println("login successfylly");
                    return resultSet.getString("name");
                }else{
                    System.out.println("login fail");
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
