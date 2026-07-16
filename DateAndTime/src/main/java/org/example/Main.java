package org.example;

import org.example.DTO.EmpRecord;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main(String[] args){
            EmpRecord er = new EmpRecord(101,"ankush");
            System.out.println(er);
            System.out.println(er.id());
            System.out.println(er.name());



        }

}
