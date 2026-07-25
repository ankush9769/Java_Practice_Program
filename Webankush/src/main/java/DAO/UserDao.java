package DAO;

import config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static void create(String name ,String username,String hashPassword){
        String sql = "insert into servletUser(name,username,password) values(?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,name);
            statement.setString(2,username);
            statement.setString(3,hashPassword);
            if(statement.executeUpdate()==1){
                System.out.println("record added succesffuylly");
            }else{
                System.out.println("error in insertion");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static String findByUsernameAndPassword(String username,String password) throws SQLException
    {
        String sql = "select * from servletUser where username = ? AND password = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1,username);
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
