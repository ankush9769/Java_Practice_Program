package model;

public class Transaction {

    private int userid;
    private Type type;
    private double amount;
    private double balanceafter;
    private Status status;
    private String reason;

    public Transaction(int userid, Type type, double amount, double balanceafter, Status status, String reason) {
        this.userid = userid;
        this.type = type;
        this.amount = amount;
        this.balanceafter = balanceafter;
        this.status = status;
        this.reason = reason;
    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalanceafter() {
        return balanceafter;
    }

    public void setBalanceafter(double balanceafter) {
        this.balanceafter = balanceafter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }





}
