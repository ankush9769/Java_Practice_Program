package com.masstechBuisnessSolution;
class Calculatormethods{
    public void add(int a,int b){
        System.out.println("addition of two integer="+(a+b));
    }
    public void add(int a,int b,int c){
        System.out.println("addition of three integer="+(a+b+c));
    }
    public void add(double a,double b){
        System.out.println("addition of two double="+(a+b));
    }

    public void multiplication(int a,int b){
        System.out.println("addition of two integer="+(a*b));
    }
    public void multiplication(int a,int b,int c){
        System.out.println("addition of three integer="+(a*b*c));
    }
    public void multiplication(double a,double b){
        System.out.println("addition of two double="+(a*b));
    }

}
public class Calculator {
    public static void main(String[] args){
        Calculatormethods m = new Calculatormethods();
        m.add(1,3);
        m.add(4.7,5.0);
    }
}
