package Day5;
class BankAccount{

    private  String accountHolderName;
    private long accountNo;
    private String ifsc;
    private double accountBalance;

    BankAccount(String accountHolderName, long accountNo,String ifsc,double accountBalance){

        this.accountHolderName=accountHolderName;
        this.accountNo=accountNo;
        this.ifsc=ifsc;
        this.accountBalance=accountBalance;}

// getter

    public String getAccountHolderName() {
        return accountHolderName;
    }
    public long getAccountNo(){
        return accountNo;
    }

    public String getIfsc(){
        return ifsc;
    }

    public double getAccountBalance(){
        return accountBalance;}


    // setter
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public void setAccountNo(long accountNo){
        this.accountNo=accountNo;
    }
    public void setIfsc(String ifsc){
        this.ifsc=ifsc;
    }
    public void setAccountBalance(double accountBalance){
        this.accountBalance=accountBalance;
    }

    public void transfer(BankAccount receiver, double amount) {

        if (amount <= accountBalance) {

            this.debit(amount);          // Debit sender
            receiver.credit(amount);     // Credit receiver

            System.out.println("Transfer Successful!");
            System.out.println("Transferred ₹" + amount + " from "
                    + this.accountHolderName + " to " + receiver.accountHolderName);

        } else {
            System.out.println("Transfer Failed! Insufficient Balance.");
        }
    }






    public void credit(double amount)
    {
        accountBalance += amount;
        System.out.println("₹" + amount + " credited successfully.");
        System.out.println("Available Balance: ₹" + accountBalance);
    }

    public void debit(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("₹" + amount + " debited successfully.");
            System.out.println("Available Balance: ₹" + accountBalance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}



