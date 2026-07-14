package service;

import dao.AdminDao;
import dao.CustomerDao;
import dao.DriverDao;
import model.Admin;
import model.Customer;
import model.Driver;
import util.PasswordUtil;

import java.sql.SQLException;

public class AuthService {
    private final CustomerDao customerDao;
    private final DriverDao driverDao;
    private final AdminDao adminDao;

    public AuthService(CustomerDao customerDao, DriverDao driverDao, AdminDao adminDao) {
        this.customerDao = customerDao;
        this.driverDao = driverDao;
        this.adminDao = adminDao;
    }

    public Customer registerCustomer(String name,String email,String phone,String password)throws SQLException
    {
        return customerDao.create(name,email,phone, PasswordUtil.hash(password));
    }
    public Customer loginCustomer(String email,String password)throws SQLException
    {
        return customerDao.findByEmailAndPassword(email,PasswordUtil.hash(password));
    }

    public Driver registerDriver(String name,String email,String phone,String password,
                                 String vehicleNo,String currentLocaion)throws SQLException
    {
        return driverDao.create(name,email,phone, PasswordUtil.hash(password),vehicleNo,currentLocaion);
    }
    public Driver loginDriver(String email,String password)throws SQLException
    {
        return driverDao.findByEmailAndPassword(email,PasswordUtil.hash(password));
    }

    public Admin loginAdmin(String email, String password)throws SQLException
    {
        return adminDao.findByEmailAndPassword(email,PasswordUtil.hash(password));
    }






}
