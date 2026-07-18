package C;

public class DriverCustomer {
    public static void  main(String[] args){
        Customer customer=new PremiumCustomer(10000);
        Customer customer1=new RegularCustomer(10000);
        if(customer instanceof PremiumCustomer pc){
            System.out.println(pc.amount-(pc.amount*pc.discount()));
        }
        if (customer1 instanceof  RegularCustomer rc){
            System.out.println(rc.amount-(rc.amount*rc.discount()));}
    }
}
