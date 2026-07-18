package model;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private String email;
    private int accountno;
    private String ifsc;
    private String branch;
    private String role;
    private double balance;
    private String password;

    public User(int id, String name, String email, int accountno, String ifsc, String branch, String role, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountno = accountno;
        this.ifsc = ifsc;
        this.branch = branch;
        this.role = role;
        this.balance = balance;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
