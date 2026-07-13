package model;

import java.math.BigDecimal;

public class Driver {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    private long id;
    private String name;
    private String email;
    private String phone;
    private String vehicleNo;
    private String currentLocation;
    private boolean available;
    private BigDecimal rating;

    public Driver(long id, String name, String email, String phone, String vehicleNo, String currentLocation, boolean available, BigDecimal rating) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.vehicleNo = vehicleNo;
        this.currentLocation = currentLocation;
        this.available = available;
        this.rating = rating;
    }




}
