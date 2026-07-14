package service;

import dao.DriverDao;
import dao.RideDao;
import model.Driver;
import model.Ride;

import java.math.BigDecimal;
import java.sql.SQLException;

public class RideService {
    private final RideDao rideDao;
    private final DriverDao driverDao;

    public RideService(RideDao rideDao,DriverDao driverDao){
        this.rideDao = rideDao;
        this.driverDao = driverDao;
    }

    public Ride bookRide(long customerId,String pickup,String drop)throws SQLException {
        BigDecimal fare = estimateFare(pickup,drop);
        return rideDao.create(customerId,pickup,drop,fare);
    }

    public boolean acceptRide(long rideId, Driver driver)throws SQLException{
        if(!driver.isAvailable()){
            throw new IllegalStateException("Driver must be availble to accept a ride");
        }
        boolean accepted = rideDao.acceptRide(rideId,driver.getId());
        if(accepted){
            driverDao.updateAvailability(driver.getId(),false);
        }
        return accepted;
    }

    public boolean completeRide(long rideId,long driverId)throws SQLException{
        boolean completed = rideDao.completeRide(rideId,driverId);
        if(completed){
            driverDao.updateAvailability(driverId,true);
        }
        return completed;
    }

    private BigDecimal estimateFare(String pickup,String drop){
        int distacneScore = Math.max(1,Math.abs(pickup.length()-drop.length())+5);
        return BigDecimal.valueOf(50 + distacneScore * 18L);
    }



}
