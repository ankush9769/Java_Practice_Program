import java.util.Scanner;

public class CreditCardLimitException extends Exception {

    public CreditCardLimitException(String message) {
        super(message);
    }
    public void transaction(double amount) throws CreditCardLimitException {
        if (amount > 100000) {
            throw new CreditCardLimitException("Credit Card Transaction Limit is Over.");
        }
        System.out.println("Transaction Successful.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CreditCardLimitException obj = new CreditCardLimitException("Transaction Exception");
        char choice;
        do {
            System.out.print("Enter Transaction Amount: ");
            double amount = sc.nextDouble();
            try {
                obj.transaction(amount);
            } catch (CreditCardLimitException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Do you want another transaction? (Y/N): ");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
        System.out.println("Limit Exceeddd");
        sc.close();
    }
}