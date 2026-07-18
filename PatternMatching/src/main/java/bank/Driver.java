package bank;
public class Driver{
    public static void main(String[] args) {
        Account acc = new Account(101, "Rahul", 5000);

        acc.credit(3000);

        try {
            acc.debit(3000);
            acc.debit(10000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}