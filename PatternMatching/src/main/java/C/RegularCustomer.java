package C;

public class RegularCustomer implements Customer {

    double amount ;

    public RegularCustomer(double amount) {
        this.amount = amount;
    }

    @Override
    public double discount() {
        return 0.1;
    }
}