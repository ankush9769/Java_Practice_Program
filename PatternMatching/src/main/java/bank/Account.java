package bank;

public class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }


    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Credited: " + amount);
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Invalid credit amount.");
        }
    }

    public void debit(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Invalid debit amount.");
        } else if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance! Available Balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Amount Debited: " + amount);
            System.out.println("Current Balance: " + balance);
        }
    }
}
