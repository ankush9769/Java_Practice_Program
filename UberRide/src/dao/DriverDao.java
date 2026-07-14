package dao;

import config.DatabaseConnection;
import model.Customer;
import model.Driver;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDao {
    public Driver create(String name, String email, String phone, String passwordHash,
                         String vehicleNo, String currentLocaion) throws SQLException {
        String sql = "insert into drivers(name,email,phone,password_hash,vehicle_no,current_location)" +
                " values(?,?,?,?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS))
        {
            //TODO: to return generated key -> to make auto generated keys RETRIEVAL
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,phone);
            statement.setString(4,passwordHash);
            statement.setString(5,vehicleNo);
            statement.setString(6,currentLocaion);


            statement.executeUpdate();
            try(ResultSet keys = statement.getGeneratedKeys())
            {
                keys.next();
                Driver driver = findById(keys.getLong(1));
                if(driver == null){
                    throw new SQLException("failed to load newly created driver");
                }
                return driver;
            }
        }
    }

    public List<Driver> findAll() throws SQLException{
        String sql = "select * from drivers order by created_at desc";
        List<Driver> drivers = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                drivers.add(map(resultSet));
            }
        }
        return drivers;
    }

    public void updateAvailability(long driverId,boolean available)throws SQLException{
        String sql = "update drivers set available = ? where id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setBoolean(1,available);
            statement.setLong(2,driverId);
            statement.executeUpdate();
        }
    }

    //Update Availability by Driver
    public Driver findByEmailAndPassword(String email,String password) throws SQLException
    {
        String sql = "select * from drivers where email = ? AND password_hash = ?";
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
    public Driver findById(Long id)throws SQLException
    {
        String sql = "select * from drivers where id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery())
            {
                return resultSet.next() ? map(resultSet) : null;  //map is not built in method
            }
        }
    }
    private Driver map(ResultSet resultSet) throws SQLException
    {
        return new Driver(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("vehicle_no"),
                resultSet.getString("current_location"),
                resultSet.getBoolean("available"),
                resultSet.getBigDecimal("rating")
        );
    }




}
