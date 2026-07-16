package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private LocalDate date;

    public Employee(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
    public void yearExprience(){
        Period period = Period.between(date,LocalDate.now());
        System.out.println("year of exepeince ="+period.getYears());
    }
    public static void main(String[] args){
        Employee e = new Employee(101,"ankush",LocalDate.of(2020,12,11));
        e.yearExprience();

        //var
        var e2 = new Employee(101,"ankush",LocalDate.of(2020,12,11));
        e2.yearExprience();


    }
}
