package util;

import dao.AdminDao;
import dao.CustomerDao;
import dao.DriverDao;
import dao.RideDao;
import model.Customer;
import service.AuthService;
import service.RideService;

import java.sql.SQLException;
import java.util.Scanner;

public class StartupUtil {
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerDao customerDao = new CustomerDao();
    private final DriverDao driverDao = new DriverDao();
    private final RideDao rideDao = new RideDao();
    private final AuthService authService  = new AuthService(customerDao,driverDao,new AdminDao());
//    private final RideService rideService = new RideService(rideDao,driverDao);

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

        }
        System.out.println("customer login successfully with id:"+customer.getId());
    }
    private void customerMenu(Customer customer){
        while(true){
            System.out.println("\n Customer Menu: "+customer.getName());
            System.out.println("1. Book Ride");
            System.out.println("2. Cancel Ride");
            System.out.println("3. Ride history");
            System.out.println("4. logout");
            int choice = readInt("choose");

            switch (choice){
                case 1 ->{

                }
            }
        }
    }


}
