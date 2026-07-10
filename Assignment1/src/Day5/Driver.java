package Day5;

public class Driver {

    public static void main(String[] args) {

        BankAccount acc = new BankAccount("Rohit", 12345678901L, "SBIN0001234", 50000);
        System.out.println("Account Holder : " + acc.getAccountHolderName());
        System.out.println("Account Number : " + acc.getAccountNo());
        System.out.println("IFSC Code      : " + acc.getIfsc());
        System.out.println("Balance        : ₹" + acc.getAccountBalance());


        acc.credit(10000);
        acc.debit(15000);

        BankAccount acc1 = new BankAccount("Rohit", 12345678901L,
                "SBIN0001234", 50000);

        BankAccount acc2 = new BankAccount("Amit", 98765432101L,
                "HDFC0005678", 20000);

        System.out.println("Before Transfer");

        System.out.println(acc1.getAccountHolderName() +
                " Balance : ₹" + acc1.getAccountBalance());

        System.out.println(acc2.getAccountHolderName() +
                " Balance : ₹" + acc2.getAccountBalance());

        // Transfer ₹15000 from Rohit to Amit
        acc1.transfer(acc2, 15000);

        System.out.println("\nAfter Transfer");

        System.out.println(acc1.getAccountHolderName() +
                " Balance : ₹" + acc1.getAccountBalance());

        System.out.println(acc2.getAccountHolderName() +
                " Balance : ₹" + acc2.getAccountBalance());



    }}
