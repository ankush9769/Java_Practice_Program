package dao;

import config.DatabaseConnection;
import model.Customer;
import model.Ride;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RideDao {
    public Ride create(long customerId, String pickup, String drop, BigDecimal fare) throws SQLException
    {
        String sql = "insert into rides(customer_id,pickup_locaion,drop_location,fare,status) values(?,?,?,?,'REQUESTED')";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS))
        {
            statement.setLong(1,customerId);
            statement.setString(2,pickup);
            statement.setString(3,drop);
            statement.setBigDecimal(4,fare);
            statement.executeUpdate();
            try(ResultSet keys = statement.getGeneratedKeys()){
                keys.next();
                Ride ride = findById(keys.getLong(1));
                if(ride == null){
                    throw new SQLException("failed to load newly created ride");
                }
                return ride;
            }
        }
    }

    public Ride findById(Long id)throws SQLException
    {
        String sql = "select * from rides where id = ?";
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
    private Ride map(ResultSet resultSet) throws SQLException
    {
        return new Ride(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone")
        );
    }
}
