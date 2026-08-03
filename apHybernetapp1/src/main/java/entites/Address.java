package entites;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressid;
    private String streep;
    private String city;
    private boolean isopen;
    private LocalDate date;
    @Lob
    private byte[] image;



    public Address( String streep, String city, boolean isopen, LocalDate date, byte[] image, double x) {
        this.streep = streep;
        this.city = city;
        this.isopen = isopen;
        this.date = date;
        this.image = image;
        this.x = x;
    }
    public Address(){

    }

    @Transient          //For hiding the variables to insert in the table
    private double x;



    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public String getStreep() {
        return streep;
    }

    public void setStreep(String streep) {
        this.streep = streep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isIsopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }



}
