package dao;

import config.DatabaseConnection;
import model.Admin;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    public Admin findByEmailAndPassword(String email, String password) throws SQLException
    {
        String sql = "select * from admins where email = ? AND password_hash = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1,email);
            statement.setString(2,password);

            try(ResultSet resultSet= statement.executeQuery()){
              //  System.out.println(resultSet.getString("email"));
                if(resultSet.next()){
                    return new Admin(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email")
                    );
                }
                return null;
            }
        }
    }
}
