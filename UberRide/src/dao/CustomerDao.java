package dao;

import config.DatabaseConnection;
import model.Customer;
import model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public Customer create(String name,String email,String phone,String passwordHash) throws SQLException {
        String sql = "insert into customers(name,email,phone,password_hash) values(?,?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS))
        {
            //TODO: to return generated key -> to make auto generated keys RETRIEVAL
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,phone);
            statement.setString(4,passwordHash);

            statement.executeUpdate();
            try(ResultSet keys = statement.getGeneratedKeys())
            {
                keys.next();
                Customer customer = findById(keys.getLong(1));
                if(customer == null){
                    throw new SQLException("failed to load newly created customer");
                }
                return customer;
            }
        }
    }
    public Customer findById(Long id)throws SQLException
    {
        String sql = "select * from customers where id = ?";
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
    private Customer map(ResultSet resultSet) throws SQLException
    {
        return new Customer(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone")
        );
    }

    public List<Customer> findAll() throws SQLException{
        String sql = "select * from drivers customers by created_at desc";
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                customers.add(map(resultSet));
            }
        }
        return customers;
    }

    public Customer findByEmailAndPassword(String email,String password) throws SQLException
    {
        String sql = "select * from customers where email = ? AND password_hash = ?";
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
}


