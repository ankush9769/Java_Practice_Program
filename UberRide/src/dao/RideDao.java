package dao;

import config.DatabaseConnection;
import model.Customer;
import model.Ride;
import model.RideStatus;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RideDao {
    public Ride create(long customerId, String pickup, String drop, BigDecimal fare) throws SQLException
    {
        String sql = "insert into rides(customer_id,pickup_location,drop_location,fare,status) values(?,?,?,?,'REQUESTED')";
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

    public Ride findById(long id)throws SQLException
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

    //by driver for requersted rides
    public List<Ride> findRequestedRides()throws SQLException{
        return findBySql("select * from rides where status = 'REQUESTED' order by requested_at");
    }

    //For a single customer, (request by customer)
    public List<Ride> findbyCustomerId(long customerId)throws SQLException{
        String sql = "select * from rides where customer_id = ? order by requested_at desc";
        List<Ride> rides = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,customerId);
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    rides.add(map(resultSet));
                }
            }
        }
        return rides;
    }

    //find all rides by driver
    public List<Ride> findByDriverId(long driverId) throws SQLException{
        String sql = "select * from rides where driver_id = ? order by requested_at desc";
        List<Ride> rides = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,driverId);
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    rides.add(map(resultSet));
                }
            }
        }
        return rides;
    }

    //to list out all rides by admin
    public  List<Ride> findAll()throws SQLException{
        return findBySql("select * from rides order by requested_at desc");
    }

    //cancle ride by customer
    public boolean cancelRide(long rideId,long customerId)throws SQLException{
        String sql= """
                update rides set status = 'CANCELLED'
                where id  = ? and customer_id = ? and status = 'REQUESTED'
                """;
            try(Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setLong(1,rideId);
                statement.setLong(2,customerId);
                return statement.executeUpdate()==1;
            }
    }

    //accepted by driver
    public boolean acceptRide(long rideId,long driverId)throws SQLException{
        String sql = """
                update rides set driver_id = ?,status = 'ACCEPTED'
                where id = ? and status = 'REQUESTED'
                """;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,driverId);
            statement.setLong(2,rideId);
            return statement.executeUpdate()==1;
        }
    }

    //ride marked completed by driver
    public boolean completeRide(long rideId,long driverId) throws SQLException{
        String sql = """
                update rides set status = 'COMPLETED'
                WHERE  id = ? and driver_id = ? and status = 'ACCEPTED'
                """;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,rideId);
            statement.setLong(2,driverId);
            return statement.executeUpdate()==1;
        }
    }

    //findBySql
    private List<Ride> findBySql(String sql)throws SQLException{
        List<Ride> rides = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                rides.add(map(resultSet));
            }
        }
        return rides;
    }

    private Ride map(ResultSet resultSet) throws SQLException
    {
        Timestamp requestedAt = resultSet.getTimestamp("requested_at");
        Timestamp updatedAt = resultSet.getTimestamp("updated_at");
        long driverId = resultSet.getLong("driver_id");
        return new Ride(
                resultSet.getLong("id"),
                resultSet.getLong("customer_id"),
                resultSet.wasNull() ? null : driverId,
                resultSet.getString("pickup_location"),
                resultSet.getString("drop_location"),
                resultSet.getBigDecimal("fare"),
                RideStatus.valueOf(resultSet.getString("status")),
                requestedAt.toLocalDateTime(),
                updatedAt.toLocalDateTime()
        );
    }
}
