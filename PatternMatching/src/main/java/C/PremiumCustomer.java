package C;

public class PremiumCustomer implements Customer {

    double amount ;

    public PremiumCustomer(double amount) {
        this.amount = amount;
    }

    @Override
    public double discount() {
        return 0.2;
    }
}