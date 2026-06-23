package array;

public class ItemPrice {
    public static void main(String[] args){
        String[] name = {"pencile","box","eraser","leptop","phone"};
        int[] price = {5,10,2,1000,500};
        int[] discount ={10,15,5,20,20};
        int[] quantity = {10,5,10,2,4};
        int total=0;

        for(int i= 0 ;i<name.length;i++){
            System.out.println("name = "+name[i]);
            System.out.println("price = "+price[i]);
            System.out.println("discount = "+discount[i]);
            System.out.println("quantity = "+quantity[i]);

            int totalprice = price[i]-((discount[i]*price[i])/100);
            total = total + totalprice;
            System.out.println("total price is = "+totalprice);
            System.out.println(" ");
        }
        System.out.println("total amount to be paid = "+total);
    }
}
