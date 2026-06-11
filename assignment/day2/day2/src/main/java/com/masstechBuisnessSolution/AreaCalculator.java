package com.masstechBuisnessSolution;
class AreaCalculatormethod{
    public void areaCalculate(double side){
        System.out.println("area of squar="+side*4);
    }
    public void areaCalculate(double l,double b){
        System.out.println("area of rectangle="+l*b);
    }
    public void areaCalculate(float radius){
        System.out.println("area of circle="+3.14*radius*radius);
    }
    public void areaCalculate(float base,float height){
        System.out.println("area of traingle="+0.5*base*height);

    }
}
public class AreaCalculator extends AreaCalculatormethod{
    public static void main(String[] args){
        AreaCalculator obj = new AreaCalculator();
        obj.areaCalculate(5.0);
        obj.areaCalculate(10.0, 20.0);
        obj.areaCalculate(7.0f);
        obj.areaCalculate(5.0f, 8.0f);
    }
}
