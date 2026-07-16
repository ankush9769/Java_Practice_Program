
public record Order(int orderid,String status,String customerName,double amount) {
    //canonical constuctor
    //every records has constructor containing all the field and we can override it
//    public Order(int orderid,String status,String customerName,double amount){
//        this.orderid = orderid;
//        this.status = status;
//        this.customerName = customerName;
//        this.amount = amount*(0.20);  //when you want to change soming in the value
//    }
    public Order{
        if(orderid < 0){
            throw new IllegalArgumentException("invalid statement");
        }
        if(amount > 5000){
            amount = amount*0.20;
        }
    }



    //You can keep methods inside records.
    public void highpaid(){
        System.out.println("highPaid()");
        if(amount>5000){
            System.out.println("yes you can keep methods inside records");
        }
        else {
            System.out.println("ehlo");
        }
    }

    //static method
    public static void sayHello(){
        System.out.println("hello");
    }

}
public static void main(String[] args){
    Order order = new Order(1,"pass","sujal",7000);
    System.out.println(order);
    order.highpaid();
    Order.sayHello();

}
