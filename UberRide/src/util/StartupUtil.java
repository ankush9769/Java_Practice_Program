package util;

import dao.AdminDao;
import dao.CustomerDao;
import dao.DriverDao;
import dao.RideDao;
import model.Admin;
import model.Customer;
import model.Driver;
import model.Ride;
import service.AuthService;
import service.RideService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class StartupUtil {
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerDao customerDao = new CustomerDao();
    private final DriverDao driverDao = new DriverDao();
    private final RideDao rideDao = new RideDao();
    private final AuthService authService  = new AuthService(customerDao,driverDao,new AdminDao());
    private final RideService rideService = new RideService(rideDao,driverDao);

    public void start(){
        while(true){

            System.out.println("\n Uber ride application");
            System.out.println("1. customer register");
            System.out.println("2. Customer login");
            System.out.println("3. Driver register");
            System.out.println("4. Driver login");
            System.out.println("5. Admin login");
            System.out.println("0. Exit");
            int choice = readInt("choose");

            try{
                switch (choice){
                    case 1 -> registerCustomer();
                    case 2 -> loginCustomer();
                    case 3 -> registerDriver();
                    case 4 -> loginDriver();
                    case 5 -> loginAdmin();
                    case 0 ->{
                        return;
                    }
                    default -> System.out.println("invalid option");
                }
            }catch(Exception exception){
                System.out.println("error="+exception.getMessage());
            }
        }
    }
    public String readLine(String label){
        System.out.print(label);
        return scanner.nextLine();
    }
    //TODO:taking string inputs
    private long readLong(String label){
        return Long.parseLong(readLine(label));
    }

    //TODO:taking string input
    private boolean readBoolean(String label){
        return Boolean.parseBoolean(readLine(label));
    }


    public int readInt(String label){
        return Integer.parseInt(readLine(label));
    }
    public void registerCustomer()throws SQLException {
        Customer customer = authService.registerCustomer(
                readLine("name: "),
                readLine("email: "),
                readLine("phone: "),
                readLine("password: "));
        System.out.println("customer registered with id:"+customer.getId());
    }
    public void loginCustomer()throws SQLException{
        Customer customer = authService.loginCustomer(
                readLine("email: "),
                readLine("password: ")
        );
        if(customer == null){
            System.out.println("No customer found");
            return;
        }

        System.out.println("customer login successfully with id:"+customer.getId());
        customerMenu(customer);
    }
    public void registerDriver()throws SQLException {
        Driver driver = authService.registerDriver(
                readLine("name: "),
                readLine("email: "),
                readLine("phone: "),
                readLine("password: "),
                readLine("vehicle_no: "),
                readLine("current_location: "));
        System.out.println("driver registered with id:"+driver.getId());
    }
    public void loginDriver()throws SQLException{
        Driver driver = authService.loginDriver(
                readLine("email: "),
                readLine("password: ")
        );
        if(driver == null){
            System.out.println("No driver found");
            return;
        }
        System.out.println("driver login successfully with id:"+driver.getId());
        driverMenu(driver);
    }
    public void loginAdmin()throws SQLException{
        Admin admin = authService.loginAdmin(
                readLine("email: "),
                readLine("password: ")
        );
        if(admin == null){
            System.out.println("No admin found");
            return;
        }

        System.out.println("admin login successfully with id:"+admin.getId());
        adminMenu(admin);
    }





    private void customerMenu(Customer customer) throws SQLException{
        while(true){
            System.out.println("\n Customer Menu: "+customer.getName());
            System.out.println("1. Book Ride");
            System.out.println("2. Cancel Ride");
            System.out.println("3. Ride history");
            System.out.println("4. logout");
            int choice = readInt("choose");

            switch (choice){
                case 1 ->{
                    Ride ride = rideService.bookRide(
                            customer.getId(),
                            readLine("pickup location"),
                            readLine("drop location")
                    );
                    System.out.println("Ride requested. RideId = "+ ride.getId() +", Fare="+ ride.getFare());
                }
                case 2 ->{
                    long rideId = readLong("Ride id:");
                    System.out.println(rideDao.cancelRide(rideId, customer.getId())
                    ? "Ride cancelled."
                            :"only requested rides owned by you can be canclelled.");

                }
                case 3 -> printRides(rideDao.findbyCustomerId(customer.getId()));
                case 0 ->{
                    return;
                }
                default -> System.out.println("invalid option");
                }
            }
        }

    private void printRides(List<Ride> rides){
        if(rides.isEmpty()){
            System.out.println("no rides found");
            return;
        }
        rides.forEach(ride -> System.out.printf(
                "Id=%d, Customer=%d, Driver=%s, From=%s, To=%s, Fare=%s, Status=%s, Requested=%s, Updated=%s%n",
                ride.getId(),ride.getCustomerId(),ride.getDriverId(),ride.getPickupLocation(),
                ride.getDropLocation(),ride.getFare(),ride.getStatus(),ride.getRequestedAt(),ride.getUpdatedAt()
        ));
    }


    private void driverMenu(Driver signedInDrive) throws SQLException{
        while(true){
            Driver driver = driverDao.findById(signedInDrive.getId());
            if(driver == null){
                System.out.println("Driver record not found. logging out.");
                return;
            }
            System.out.println("\n Driver menu: "+driver.getName());
            System.out.println("1. update availability");
            System.out.println("2. view requested rides");
            System.out.println("3. accept ride");
            System.out.println("4. complete ride");
            System.out.println("5. my rides");
            System.out.println("6. logout");
            int choice = readInt("choose");

            switch (choice){
                case 1 -> driverDao.updateAvailability(driver.getId(),
                        readBoolean("Available true / false"));
                case 2 -> printRides(rideDao.findRequestedRides());//TODO: rides with status 'REQUESTED'
                case 3 -> {
                    long rideId = readLong("Ride id: ");
                    System.out.println(rideService.acceptRide(rideId,driver)
                    ? "Ride accepted."
                            : "Ride is no longer available.");
                }
                case 4 -> {
                    long rideId = readLong("ride id: ");
                    System.out.println(rideService.completeRide(rideId,driver.getId())
                    ? "Ride completed."
                            : "only your accepted ride can be conpleted");
                }
                case 5 -> printRides(rideDao.findByDriverId(driver.getId()));
                case 6 -> {
                    return;
                }
                default -> System.out.println("invalid option");
            }
        }
    }

    private void adminMenu(Admin admin)throws  SQLException{
        while (true){
            System.out.println("\n admin menu: "+admin.getName());
            System.out.println("1. view customer");
            System.out.println("2. view drivers");
            System.out.println("3. view rides");
            System.out.println("4. logout");
            int choice = readInt("choose: ");

            switch (choice){
                case 1 ->{
                    customerDao.findAll().forEach(customer -> System.out.printf(
                            "Id=%d, Name=%s, Email=%s, Phone=%s%n",
                            customer.getId(),customer.getName(),customer.getEmail(),customer.getPhone()
                    ));
                }
                case 2 ->{
                    driverDao.findAll().forEach(driver -> System.out.printf(
                            "Id=%d, Name=%s, Email=%s, Vehicle=%s, Location=%s, Available=%s, Rating=%S%n",
                            driver.getId(),driver.getPhone(),driver.getEmail(),driver.getVehicleNo(),
                            driver.getCurrentLocation(),driver.isAvailable(),driver.getRating()
                    ));
                }
                case 3 -> printRides(rideDao.findAll());
                case 0 -> {
                    return;
                }
                default -> System.out.println("invalid option");
            }
        }
    }
}






