package org.example.Produce_Consume;

public class A {
    boolean flag= true;
    int count=0;
    public synchronized void produce() throws InterruptedException {
        while(count<=51){
            if(flag == true){
                count=count+1;
                System.out.println("producer procuded itme "+count);
                flag = false;
                notify();
                wait();
            }else{
                wait();
            }
        }
    }
    public synchronized void consume() throws InterruptedException {
        while(count<=51){
            if(flag==true){
                wait();
            }else{
                System.out.println("consumer consume the item "+count);
                flag = true;
                notify();
                wait();
            }
        }
    }
}
